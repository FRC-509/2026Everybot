package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
    
    private final static TalonFX climbMotor = new TalonFX(Constants.IDs.kClimbMotor, Constants.kRio);
    private final static PositionDutyCycle rotationClosedLoop = new PositionDutyCycle(0.0).withEnableFOC(false);
    private final static VoltageOut openLoop = new VoltageOut(0).withEnableFOC(false);
    private final static CANcoder encoder = new CANcoder(/*ID*/); //may need CANBus type

    // sets constants for the motor, sets them to the Rio, then gets motor position - presumably in degrees - and returns the value in the double data type, and does not enable FOC

    private double initialRotation; //sets initial rotation, under the double datatype
    private double currentPosition; //-0.5 to +0.5 rotations
    private boolean hasReset; //checks if robot is reset, probably to see if it needs to remember the rotation for the motor

    //private DigitalInput maximumLimitSwitch = new DigitalInput(9);
    private DigitalInput limitSwitch = new DigitalInput(1); //sets the digital input (1/0) to the limitswitch as 1

    public Climb() {
        TalonFXConfiguration climbConfig = new TalonFXConfiguration(); //creates a TalonFXConfigurator named climbConfig, as you config the TalonFX motor to config the motor therefore config the climber therefore config the climb. perchance.
        climbConfig.Feedback.FeedbackRemoteSensorID = cancoder.getDeviceID();
        climbConfig.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.FusedCANcoder;
        climbConfig.Feedback.SensorToMechanismRatio = 1.0;

        climbConfig.slot0.kP = 0;
        climbConfix.slot0.kI = 0;
        climbConfix.slot0.kD = 0;

        climbMotor.getConfigurator().apply(climbConfig);
        
        CANcoderConfiguration coderConfigs = new CANcoderConfiguration();
        coderConfigs.MagnetSensor.AbsoluteSensorRange = AbsoluteSensorRange.Signed_PlusMinusHalf;
        //configs.MagnetSensor.MagnetOffset = ;
        coderConfigs.MagnetSensor.SensorDirection = SensorDirectionValue.CounterClockwise_Positive;
        encoder.getConfigurator().apply(coderConfigs);

        initialRotation = encoder.getAbsolutePosition().refresh().getValueAsDouble();
    }

    public double getPosition() {
        return encoder.getAbsolutePosition().refresh().getValueAsDouble();
    }
    public void setPosition(double position) {
        Math.calmp(-0.5, position, 0.5);
        climbMotor.setControl(rotationClosedLoop.withPosition(position));
    }
}
