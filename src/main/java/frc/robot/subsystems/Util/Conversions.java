package frc.robot.subsystems.Util;

public class Conversions {
    
    public static double falconToDegrees(double positionCounts, double gearRatio) {
		return positionCounts * (360.0 / gearRatio);
}
