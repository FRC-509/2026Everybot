package frc.robot.subsystems;

import java.util.Map;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.BooleanSupplier;
import edu.wpi.first.wpilibj.util.color;
import edu.wpi.first.wpilibj.DriverStation;


public class LEDLights extends SubsystemBase {
    public static final Color allyColor = (DriverStation.getAlliance() == Alliance.Red)? Color.kRed: Color.kBlue;

    private static final AddressableLED m_led = new AddressableLED(0); //replace PWM port with constant later

    private static AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(123); //set the length of the strip here
    private static AddressableLEDBufferView m_turretBufferView = m_ledBuffer.createView(0, 50);
    private static AddressableLEDBufferView m_underglowBufferView = m_ledBuffer.createView(51, 100);
    
    //set these in the robot container using the subsystems/command's methods
    public static BooleanSupplier isClimbing = () -> false;
    public static BooleanSupplier isAutoComplete = () -> false;
    public static BooleanSupplier isFiring = () -> false;
    public static BooleanSupplier cantAim = () -> false;
    public static DoubleSupplier shooterTorque = () -> 1.0;

    public enum UnderglowStates {
        PASSIVE(LEDPattern.solid(allyColor)),
        AUTO_COMPLETED(LEDPattern.solid(Color.kGreen)),
        CLIMBING(LEDPattern.rainbow(255, 120).scrollAtRelativeSpeed(Percent.per(second).of(25)));

        public LEDPattern pattern;

        private UnderglowStatesStates(LEDPattern pattern) {
            this.pattern = pattern;
        }

        public void apply(double brightness) {
            LEDPattern patternToSet = pattern.atBrightness(brightness);
            patternToSet.applyTo(m_underglowBufferView);
            m_led.setData(m_ledBuffer);
        }
    }
    
    public enum TurretStates {
        PASSIVE(LEDPattern.solid(allyColor).breathe(Seconds.of(2))),
        FIRING(LEDPattern.solid(allyColor)),
        CANT_AIM(
            LEDPattern.solid(allyColor).mask(
                LEDPattern.steps(Map.of(0, Color.kWhite, 0.5, Color.kBlack).scrollAtRelativeSpeed(
                    Percent.per(Second).of(0.25)))
            )),
        AUTO_COMPLETED(LEDPattern.solid(kGreen)),
        CLIMBING(LEDPattern.rainbow(255, 120).scrollAtRelativeSpeed(Percent.per(second).of(25)));

        public LEDPattern pattern;

        private TurretStates(LEDPattern pattern) {
            this.pattern = pattern;
        }

        public void apply(double brightness) {
            LEDPattern patternToSet = pattern.atBrightness(brightness);
            patternToSet.applyTo(m_turretBufferView);
            m_led.setData(m_ledBuffer);
        }
    }

    public LEDLights(){
        m_led.setLength(m_ledBuffer.getLength());
        m_led.setData(m_ledBuffer);
        m_led.start();
    }

    @Override
    public void periodic(){ //auto will be set later, as it is only a temperary set
        if(isClimbing.getAsBoolean()){
            UnderglowStates.CLIMBING.apply(1);
            TurretStates.CLIMBING.apply(1);
        } else {
            UnderglowStates.PASSIVE.apply(1);
        }

        if(isFiring.getAsBoolean()){
            TurretStates.FIRING.apply(shooterTorque.getAsDouble);
        } else if(cantAim.getAsBoolean()){
            TurretStates.CANT_AIM.apply(1);
        } else{
            TurretStates.PASSIVE.apply(1);
        }
    }
}