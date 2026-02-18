// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class Chassis {
    public static final double koffsetToSwerveModule = 0;

    public static final double kfrontLeft = 0;
    public static final double kfrontRight = 0;
    public static final double kbackLeft = 0;
    public static final double kbackRight = 0;
  }

  public static class Turret {
    public static final double kTurretHeightFromGround = 0;
    public static final double kTurretAngleDegrees = 17;
    public static double kMaxExitingVelocity = 0;
    public static int kAngularSpeed = 0;
    public static int kFlyWheelRadius = 0;
  }

  public static class Field {

    public static int kFuelRadius;

  }

  public static class Vision {
    public static final double kCameraHeight = 0;
    public static final double kCameraAngleDegrees = 0;
    public static final double kAprilTagHeight = 0;
    public static final double kAprilTagToCameraHeight = kCameraHeight - kAprilTagHeight;
    
  }
}
