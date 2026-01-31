package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


//to do 
//1. CONSTANTS


public class SwerveDrive extends SubsystemBase{
    
    

    public static final TalonFX steerMotor1 = new TalonFX();
    public static final TalonFX driveMotor1 = new TalonFX();
    
    // public static final TalonFX steerMotor2 = new TalonFX();
    // public static final TalonFX driveMotor2 = new TalonFX();
    
    // public static final TalonFX steerMotor3 = new TalonFX();
    // public static final TalonFX drivemotor3 = new TalonFX();

    // public static final TalonFX steerMotor4 = new TalonFX();
    // public static final TalonFX drivemotor4 = new TalonFX();

    public static final PositionDutyCycle positionRequest = new PositionDutyCycle();
    public static final VelocityDutyCycle velocityRequest = new VelocityDutyCycle();
    
    
    private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
        new Translation2d(+Constants.Chassis.koffsetToSwerveModule, +Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(+Constants.Chassis.koffsetToSwerveModule, -Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(-Constants.Chassis.koffsetToSwerveModule, +Constants.Chassis.koffsetToSwerveModule),
        new Translation2d(-Constants.Chassis.koffsetToSwerveModule, -Constants.Chassis.koffsetToSwerveModule)
        );

    

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


        steerMotor1.setControl(positionRequest.withOutput());
        driveMotor1.setControl(velocityRequest.withOutput());

    }
    
}


