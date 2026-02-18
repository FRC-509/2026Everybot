package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Translation2d;

import edu.wpi.first.math.kinematics.ChassisSpeeds;

import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.drive.SwerveModule;


public class SwerveDrive extends SubsystemBase{
    
    

    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
        new Translation2d(+Constants.Chassis.koffsetToSwerveModule, +Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(+Constants.Chassis.koffsetToSwerveModule, -Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(-Constants.Chassis.koffsetToSwerveModule, +Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(-Constants.Chassis.koffsetToSwerveModule, -Constants.Chassis.koffsetToSwerveModule)
        );

    // public SwerveModule[] moduleStates = new SwerveModule[] {
    //     new SwerveModule(Constants.Chassis.kfrontLeft),
    //     new SwerveModule(Constants.Chassis.kfrontRight),
    //     new SwerveModule(Constants.Chassis.kbackLeft),
    //     new SwerveModule(Constants.Chassis.kbackRight),
    // };

    public SwerveDrive(){

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
            // moduleState 
        }


        // for (SwerveModule module : moduleStates) {
        //     // module.setDesiredState()
        // }




    }
    
}


