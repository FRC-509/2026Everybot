package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;

public class LEDLights extends SubsystemBase {
    AddressableLED m_led = new AddressableLED(0); //replace ID with constant later

    AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(123);
  
    public enum underglowStates {
        PASSIVE(),
        AUTO_COMPLETE(),
        CLIMB();
    }
    
    public enum turretStates {
        PASSIVE(LEDPattern.solid(kRed).breathe(Seconds.of(2)), () -> 100), //Replace kRed with constant for alliance color later
        FIRING(LEDPattern.solid(kRed), tempConstants.shooterIntensity),  //Replace kRed with constant for alliance color later
        CANT_AIM(LEDPattern.steps(Map.of(0, Color.kWhite, 0.5, Color.kBlack)).scrollAtRelativeSpeed(Percent.per(Second).of(0.25)), ),
        AUTO_COMPLETED(),
        CLIMBING();

        LEDPattern pattern;
        DoubleSupplier intensity;

        private turretStates(LEDPattern pattern, DoubleSupplier intensity) {
            this.pattern = pattern;
            this.intensity = intensity;

        }
    }

    public LEDLights(){
        m_led.setLength(m_ledBuffer.getLength());
        m_led.setData(m_ledBuffer);
        m_led.start();
    

    }
}