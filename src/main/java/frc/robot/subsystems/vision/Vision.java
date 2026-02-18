package frc.robot.subsystems.vision;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import frc.robot.Constants;

public class Vision {
    
    double tx = LimelightHelpers.getTX("");  // Horizontal offset from crosshair to target in degrees
    double ty = LimelightHelpers.getTY("");  // Vertical offset from crosshair to target in degrees
    
    double ta = LimelightHelpers.getTA("");  // Target area (0% to 100% of image)
    boolean hasTarget = LimelightHelpers.getTV(""); // Do you have a valid target?

    double txnc = LimelightHelpers.getTXNC("");  // Horizontal offset from principal pixel/point to target in degrees
    double tync = LimelightHelpers.getTYNC("");  // Vertical offset from principal pixel/point to target in degrees

    

    public Vision(){
        
    }

    /*
    OBJECT DETECTION
    ----------------------------------------------------
    view 1
                C  ← Camera (Limelight)
            *\
            |\
       r    | \
       o    |  \  H (hypotenuse)
       b    |   \
       o    |    \
       t    |     \
            *------* 
            P       T
            Floor   Target

    view 2
                R  ← Robot base (where wheels are)
            C  ← Camera (Limelight)
            *\
            |\
            | \
            |  \  H (line-of-sight)
            |   \
            |    \
            |     \
            *------* 
            P       T
            Floor   Target (game piece)

    */


    public double getView1PT(){
        return Constants.Vision.kCameraHeight * Math.atan(tync);
    }

    public double getView1Hypot(){
        return Constants.Vision.kCameraHeight / Math.cos(tync);
    }

    public double getView2PT(){
        return Constants.Vision.kCameraHeight * Math.tan(txnc);
    }

    public double getView2Hypot(){
        return Constants.Vision.kCameraHeight / Math.cos(txnc);
    }

// APRIL TAG LOCALIZATION
//-----------------------------------------------------------
/*
view 3
                R (robot)
                C (camera)
                *\
                |\
                | \
        r       |  \  H (line-of-sight)
        o       |   \
        b       |    \
        o       |     \
        t       |      \
                *-------*                  camera height from ground - april tag height from ground = camera height from april tag
                |       A
                |   AprilTag at known height
                |
                |P
                Floor


view 4
                P--------A   ← Top horizontal (AprilTag reference)
                |        /
                |      /
                |    /
                |  /
                |/
                C  ← Camera (on robot)
                R  ← Robot base


*/
    public double[] getCornersX() {
        return limelight.getEntry("tcornx").getDoubleArray(new double[0]);
    }

    public double[] getCornersY() {
        return limelight.getEntry("tcorny").getDoubleArray(new double[0]);
    }

    public double getView3PA(){
        return Constants.Vision.kAprilTagToCameraHeight * Math.tan(tync);
    }

    public double getView3Hypot(){
        return Constants.Vision.kAprilTagToCameraHeight / Math.sin(tync);
    }


}
