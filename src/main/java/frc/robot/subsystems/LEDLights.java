package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;

public class LEDLights {
    private final AddressableLED kLED;
    private final AddressableLEDBuffer kBuffer;


    public LEDLights(){
        kLED = new AddressableLED(0);
        kBuffer = new AddressableLEDBuffer(0);
        KlED.setLength(kLength);


        public enum TurretStates{
            NONE(),
            HOPPER(),
            NEUTRALZONE_FEED_LEFT(),
            NEUTRALZANE_FEED_RIGHT(),
            OPPOSING_ALLIANCE_FEED_LEFT(),
            OPPOSING_ALLIANCE_FEED_RIGHT();

            private final LEDPattern turretState;

            public TurretStates(LEDPattern turretPattern){
                this.turretPattern = turretPattern;
        }

        public void applyTo(AddressableLEDBuffer kBuffer){
            turretPattern.applyTo(kBuffer);
    }

        public enum HopperStates{
            PASSIVE(),
            INDEXING(),
            INTAKING(),
            INTAKE_AND_INDEXING(),
            FEED(),
            OUTTAKE();

            private final LEDPattern hopperPattern;

            public HopperState(LEDPattern hopperPattern){
                this.hopperPattern = hopperPattern;
            }

            public void applyTo(AddressableLEDBuffer kBuffer){
                hopperPattern.applyTo(kBuffer);
            }
        }

        public enum IndexerStates{
            PASSIVE(),
            LEFT(),
            RIGHT(),
            LEFT_AND_RIGHT();

            private final LEDPattern indexerPattern;

            public IndexerStates(LEDPattern indexerPattern){
                this.indexerPattern = indexerPattern;
            }

            public void applyTo(AddressableLEDBuffer kBuffer){
                indexerPattern.applyTo(kBuffer);
        }
    
}
    
        public void displayLED(){
            switch(turretState){
                case (NONE):
                    turretPattern = TurretStates.NONE;
                case (HOPPER):
                    turretPattern = TurretStates.HOPPER;
                case (NEUTRAL_ZONE_FEED_LEFT):
                    turretPattern = TurretStates.NEUTRALZANE_FEED_LEFT;
                case (NEUTRAL_ZONE_FEED_RIGHT):
                    turretPattern = TurretStates.NEUTRALZANE_FEED_RIGHT;
            }

            switch(hopperState){
                case (PASSIVE):

                case (INDEXING):

                case (INTAKING_AND_INDEXING):

                case (FEED):

                case ()
            }

            switch(indexerState){
                case
            }

            public void setState(){
                turretPattern.applyTo(kBuffer);
                hopperPattern.applyTo(kBuffer);
                indexerPattern.applyTo(kBuffer);
                ledLight.setData(kBuffer);
            }
        }

}
