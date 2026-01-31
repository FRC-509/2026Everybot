package frc.robot.subsystems.drive;

<<<<<<< HEAD
<<<<<<< HEAD
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


//to do 
//1. CONSTANTS


public class SwerveDrive extends SubsystemBase{
    
    

    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
        new Translation2d(+Constants.Chassis.koffsetToSwerveModule, +Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(+Constants.Chassis.koffsetToSwerveModule, -Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(-Constants.Chassis.koffsetToSwerveModule, +Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(-Constants.Chassis.koffsetToSwerveModule, -Constants.Chassis.koffsetToSwerveModule)
        );

    public SwerveModule[] moduleStates = new SwerveModule[] {
        new SwerveModule(Constants.Chassis.kfrontLeft),
        new SwerveModule(Constants.Chassis.kfrontRight),
        new SwerveModule(Constants.Chassis.kbackLeft),
        new SwerveModule(Constants.Chassis.kbackRight),
    };

    public SwerveDrive(){


=======
=======
>>>>>>> bc7cc16 (swerve drive)
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drive.SwerveModule;

public class SwerveDrive {
    private final SwerveModule frontLeft;
    private final SwerveModule backleft;
    private final SwerveModule frontRight;
    private final SwerveModule backRight;
    
    private final SwerveDriveKinematics kinematics;

    public SwerveDrive(){
        
<<<<<<< HEAD
>>>>>>> e20ce00 (updated swrve module)
=======
=======
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


//to do 
//1. CONSTANTS


public class SwerveDrive extends SubsystemBase{
    
    

    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
        new Translation2d(+Constants.Chassis.koffsetToSwerveModule, +Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(+Constants.Chassis.koffsetToSwerveModule, -Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(-Constants.Chassis.koffsetToSwerveModule, +Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(-Constants.Chassis.koffsetToSwerveModule, -Constants.Chassis.koffsetToSwerveModule)
        );

    public SwerveModule[] moduleStates = new SwerveModule[] {
        new SwerveModule(Constants.Chassis.kfrontLeft),
        new SwerveModule(Constants.Chassis.kfrontRight),
        new SwerveModule(Constants.Chassis.kbackLeft),
        new SwerveModule(Constants.Chassis.kbackRight),
    };

    public SwerveDrive(){


>>>>>>> ead967e (swerve drive)
>>>>>>> bc7cc16 (swerve drive)
    }

    public void drive(Translation2d translationMPS, double omega, boolean fieldRelative){
        /*

        vx = values from double supplier x axis
        xy = values from double supplier y axis
        w = values from double supplier for the rotation of the robot

         * sliding motion simply just
        vx forward back
        vy left right

        vx - w * offset
        vy + w * offset
         *  
         */

        ChassisSpeeds speed = new ChassisSpeeds(translationMPS.getX(), translationMPS.getY(), omega);

        

        double angle = Math.atan2(translationMPS.getX(), translationMPS.getY());



        if (fieldRelative){
            moduleState 
        }


        for (SwerveModule module : moduleStates) {
            module.setDesiredState()
        }



    }
    
}


