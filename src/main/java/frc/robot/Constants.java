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
  public static final double kMaxDriveVelocity = 0; //placeholder
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class MotorIDs {
    public static final int kFrontLeftMove = 0; //placeholder
    public static final int kBackLeftMove = 0; //placeholder
    public static final int kBackRightMove = 0; //placeholder
    public static final int kFrontRightMove = 0; //placeholder

    public static final int kFrontLeftTurn = 0; //placeholder
    public static final int kBackLeftTurn = 0; //placeholder
    public static final int kBackRightTurn = 0; //placeholder
    public static final int kFrontRightTurn = 0; //placeholder

    public static final int kFrontLeftEncoder = 0; //placeholder
    public static final int kBackLeftEncoder = 0; //placeholder
    public static final int kBackRightEncoder = 0; //placeholder
    public static final int kFrontRightEncoder = 0; //placeholder
  }
//declare constants here and use them later
  public static class PIDconstants {
  }
}