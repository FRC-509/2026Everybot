package frc.robot.subsystems.drive;

import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorIDs;
import frc.robot.subsystems.drive.SwerveModule;

public class SwerveDrive {
    public boolean isRobotCentric = true; //by default
    private final SwerveModule frontLeft = new SwerveModule(1, MotorIDs.kFrontLeftTurn, MotorIDs.kFrontLeftMove, MotorIDs.kFrontLeftEncoder); //this is just a placeholder for when we set it
    private final SwerveModule backLeft = new SwerveModule(2, MotorIDs.kBackLeftTurn, MotorIDs.kBackLeftMove, MotorIDs.kBackLeftEncoder); //this is just a placeholder for when we set it
    private final SwerveModule frontRight = new SwerveModule(4, MotorIDs.kFrontRightTurn, MotorIDs.kFrontRightMove, MotorIDs.kFrontRightEncoder); //this is just a placeholder for when we set it
    private final SwerveModule backRight = new SwerveModule(3, MotorIDs.kBackRightTurn, MotorIDs.kBackRightMove, MotorIDs.kBackRightEncoder); //this is just a placeholder for when we set it
    
    private final SwerveDriveKinematics kinematics = null; //this is just a placeholder for when we set it

    public SwerveDrive() {

    }

    
}
