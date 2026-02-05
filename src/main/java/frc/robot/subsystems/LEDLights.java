package frc.robot.subsystems;

import java.util.Map;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;

public class LEDLights {
    private final AddressableLED kAddressableLED;
    private final AddressableLEDBuffer kLEDBuffer;
    private final <Optional> alliance;

    private final Map<Double, Color> maskSteps;
    private final LEDPattern mask;
    





    public LEDLights(
        BooleanSupplier climbing, 
        BooleanSupplier cantAim
    ){

        kLED = new AddressableLED(0);
        kBuffer = new AddressableLEDBuffer(0);
        alliance = DriverStation.getAlliance();
        KlED.setLength(kLength);

        Map<Double, Color> maskSteps = Map.of(0, Color.kWhite, 0.5, Color.kBlack);
        LEDPattern mask =
            LEDPattern.steps(maskSteps).scrollAtRelativeSpeed(Percent.per(Second).of(0.10));

        public enum UnderGlow {
            PASSIVE(LEDPattern.solid(alliance)),
            AUTO_COMPLETED(LEDPattern.solid(Color.kGreen));
            CLIMB(LEDPattern.rainbow(255, 188));
        
            private final LEDPattern underGlowState;

            public UnderGlow(){
                this.underGlowState = underGlowState;
            }

            public void applyTo(AddressableLEDBuffer kLEDBuffer){
                underGlowState.applyTo(kLEDBuffer);
            }
        }

        public enum Turret {
            PASSIVE(alliance.breathe(Seconds.of(2))),
            // FIRING(find out),
            CANT_AIM(alliance.mask(mask)),
            AUTO_COMPLETED(LEDPattern.solid(Color.kGreen)),
            CLIMB(LEDPattern.rainbow(255, 188));
            
            private final LEDPattern turretState;
            
            public Turret(){
                this.turretState = turretState;
            }

            public void applyTo(AddressableLEDBuffer kLEDBuffer){
                turretState.applyTo(kLEDBuffer);
            }
        }
            public void setState(){
                turretPattern.applyTo(kBuffer);
                hopperPattern.applyTo(kBuffer);
                indexerPattern.applyTo(kBuffer);
                ledLight.setData(kBuffer);
            }
        }

}