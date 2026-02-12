package frc.robot.subsystems.drive;

import static edu.wpi.first.units.Units.Rotation;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.controls.VelocityDutyCycle;

public class SwerveModule {
    public final int moduleNumber;

    private final TalonFX steerMotor;
    private final TalonFX driveMotor;
    private final CANcoder m_encoder;

    private final VelocityDutyCycle closedLoop = new VelocityDutyCycle(0).withEnableFOC(false);
    
    //encoders when CTRE installed

    public SwerveModule(int moduleNumber, int steerMotorID, int driveMotorID, int encoderID) {
        
        TalonFXConfiguration configs = new TalonFXConfiguration();
        configs.slot0.kP = ;//figure these out later, this will be an error until done
        configs.slot0.kI = ;
        configs.slot0.kD = ;
        m_talonFX.getConfigurator().apply(configs);

        steerMotor = new TalonFX(steerMotorID);
        driveMotor = new TalonFX(driveMotorID);
        m_encoder = new CANcoder(encoderID);

        this.moduleNumber = moduleNumber;
    }

    /*public Rotation2d getAngle(){
        return Rotation2d.fromRotations(steerMotor.getPosition().getValueAsDouble());
    }*/
    /*
    This Method uses the CANcoder to return the position in counterclockwise rotations(0 to 1)
    */

    /*public SwerveModuleState getState(){
        return new SwerveModuleState(
            
        );
    }*/

    public double getAngle() {
        return m_encoder.getAbsolutePosition().getValueAsDouble();
    }

    public double getSpeed() {
        return closedLoop.getVelocity().getValueAsDouble();
    }

    public double[] getAngleAndSpeed() {
        return {getAngle(), getSpeed()};
    }

    public SwerveModuleState setDesiredState(double rotationAngle, double speed) {
        driveMotor.setControl(closeLoop.withVelocity(speed * Constants.kMaxVelocity));
        
    }
}
