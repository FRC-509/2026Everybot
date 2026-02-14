package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoneix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.util.Translation2dSupplier;

public class Turret extends SubsystemBase {
    private final TalonFX kRotationalMotor = new TalonFX(0);
    private final TalonFX kTopFlyWheelMotor = new TalonFX(0);
    private final TalonFX kBottomFlyWheelmotor = new TalonFX(0);

    private final PositionDutyCycle kPositionRequest = new PositionDutyCycle();
    private final VelocityDutyCycle kTopVelocityRequest = new VelocityDutyCycle();
    private final VelocityDutyCycle kBottomVelocityRequest = new VelocityDutyCycle();

    private final DoubleSupplier robotYawSupplier;
    private final Translation2dSupplier estimatedPosition; 

    private final Translation3d offsetTranslation;

    public Turret(DoubleSupplier robotYawSupplier, Translation2dSupplier estimatedPosition, Translation3d offsetTranslation){
        this.robotYawSupplier = robotYawSupplier;
        this.estimatedPosition = estimatedPosition;
        this.offsetTranslation = offsetTranslation;

        public enum TargetModes {
            HONE(Translation3d.kzero()),
            HOPPER(new Translation3d()),
            NEUTRALZONE_FEED_LEFT(new Translation3d()),
            NEUTRALZONE_FEED_RIGHT(new Translation3d()),
            OPPOSING_ALLIANCE_FEED_LEFT(new Translation3d()),
            OPPOSING_ALLIANCE_FEED_RIGHT(new Translation3d());

            public final Translation3d position;

            private TargetModes(Translation3d position) {
                this.position = position;
            }
        }
    }

    public void setFlyWheelSpeeds(){
        double[] flyWheelSpeeds = calculateFlyWheelSpeeds();

        kTopFlyWheelMotor.setControl(kTopVelocityRequest.withOutput(flyWheelSpeeds[0]));
        kBottomFlyWheelmotor.setControl(kBottomVelocityRequest.withOutput(flyWheelSpeeds[1]));
    }

    public void setRotation(double rotation){
        kRotationalMotor.setControl(kPositionRequest.withPosition(rotation));
    }

    public double calculateSpeed(){
        Translation2d turretGlobal = getTurretPosition();
        Translation3d targetTurretRelative = TargetModes.position.minus(
            new Translation3d(
                turretGlobal.getX(), 
            turretGlobal.getY(),
            Constants.Turret.kTurretHeightFromGround
        ));

        double distance = targetTurretRelative.toTranslation2d().getDistance(Translation2d.kZero);
        double theta = Math.toRadians(90 - Constants.Turret.kTurretAngleDegrees);
        double targetHeight = targetTurretRelative.getZ();


        return Math.sqrt((9.8 * Math.pow(distance, 2)) / (2 * Math.cos(theta) * Math.cos(theta) * distance * Math.tan(theta) - targetHeight));
    }

    public double[] calculateFlyWheelSpeeds(){
        Translation2d turretGlobal = getTurretPosition();
        Translation3d targetTurretRelative = TargetModes.position.minus(
            new Translation3d(
                turretGlobal.getX(), 
            turretGlobal.getY(),
            Constants.Turret.kTurretHeightFromGround
        ));

        double distance = targetTurretRelative.toTranslation2d().getDistance(Translation2d.kZero);
        double theta = Math.toRadians(90 - Constants.Turret.kTurretAngleDegrees);
        double targetHeight = targetTurretRelative.getZ();

        double exitingVelocity = MathUtil.clamp(
            Math.sqrt((9.8 * Math.pow(distance, 2)) / (2 * Math.cos(theta) * Math.cos(theta) * distance * Math.tan(theta) - targetHeight)),
            0.0d,
            Constants.Turret.kMaxExitingVelocity
        );

        double surfaceSpeed = Constants.Turret.kAngularSpeed * Constants.Field.kFuelRadius;
        double velocityTopWheel = exitingVelocity - surfaceSpeed;
        double velocityBottomWheel = exitingVelocity + surfaceSpeed;

        double flyWheelCircumference = 2 * Math.PI * Constants.Turret.kFlyWheelRadius;

        return new double[] {velocityBottomWheel / flyWheelCircumference, velocityTopWheel / flyWheelCircumference};


        
    }

    public Translation2d getTurretPosition(){
        return estimatedPosition.getAsTranslation2d().plus(
            new Translation2d(
                offsetTranslation.getX() * Math.cos(robotYawSupplier.getAsDouble() + offsetTranslation.getY() * Math.sin(robotYawSupplier.getAsDouble())),
                offsetTranslation.getX() * -Math.sin(robotYawSupplier.getAsDouble() + offsetTranslation.getY() * Math.sin(robotYawSupplier.getAsDouble()))
            ));
    }



}