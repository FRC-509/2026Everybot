package frc.robot.subsystem.drive;

import static edu.wpi.first.units.Units.Rotation;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveModule {
    public int moduleNumber;

    private final TalonFX steerMotor;
    private final TalonFX driveMotor;
    private final CANcoder encoder;

    //encoders when CTRE installed

    public SwerveModule(int moduleNumber, int steerMotorID, int driveMotorID, int encoderID){
        steerMotor = new TalonFX(steerMotorID);
        driveMotor = new TalonFX(driveMotorID);
        encoder = new CANcoder(encoderID);
    }

    public Rotation2d getAngle(){
        return Rotation2d.fromRotations(steerMotor.getPosition.getValueAsDouble());
    }

    public SwerveModuleState getState(){
        return new SwerveModuleState(
            Conversions.
        )
    }

    public SwerveModuleState setDesiredState(){
        
    }
}
