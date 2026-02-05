package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;

public class LEDLights {
    private final AddressableLED kLED;
    private final AddressableLEDBuffer kBuffer;
    private final <Optional> alliance;


    public LEDLights(BooleanSupplier ){
        kLED = new AddressableLED(0);
        kBuffer = new AddressableLEDBuffer(0);
        alliance = DriverStation.getAlliance();
        KlED.setLength(kLength);


        public enum TurretStates{
            NONE(LEDPattern.solid(alliance)),
            HOPPER(LEDPattern.solid(Color.kOrange)),
            NEUTRALZONE_FEED_LEFT(LEDPattern.solid(Color.k)),
            NEUTRALZANE_FEED_RIGHT(LEDPattern.solid(Color.k)),
            OPPOSING_ALLIANCE_FEED_LEFT(LEDPattern.solid(Color.k)),
            OPPOSING_ALLIANCE_FEED_RIGHT(LEDPattern.solid(Color.k));

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
                    hopperPattern = HopperStates.PASSIVE;
                case (INDEXING):
                    hopperPattern = HopperStates.INDEXING;
                case (INTAKING_AND_INDEXING):
                    hopperPattern = HopperStates.INTAKEING_AND_INDEXING;
                case (FEED):
                    hopperPattern = HopperStates.FEED;
                case (OUTTAKE):
                    hopperPattern = HopperStates.OUTTAKE;
            }

            switch(indexerState){
                case(PASSIVE):
                    indexerPattern = IndexerStates.PASSIVE;
                case(LEFT):
                    indexerPattern = IndexerStates.LEFT;
                case(RIGHT):
                    indexerPattern = IndexerStates.RIGHT;
                case(LEFT_AND_RIGHT):
                    indexerPattern = IndexerStates.LEFT_AND_RIGHT;
            }

            public void setState(){
                turretPattern.applyTo(kBuffer);
                hopperPattern.applyTo(kBuffer);
                indexerPattern.applyTo(kBuffer);
                ledLight.setData(kBuffer);
            }
        }

}
