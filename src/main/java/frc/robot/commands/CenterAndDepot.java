// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ChoreoAuto;
import frc.robot.commands.ShootPreloadAuto;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Hopper.HopperState;
import frc.robot.subsystems.Hopper.IndexerState;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Vortex;
import frc.robot.subsystems.drive.SwerveDrive;
import frc.robot.util.PigeonWrapper;

public class CenterAndDepot extends SequentialCommandGroup {
   public CenterAndDepot(SwerveDrive swerve, PigeonWrapper pigeon, Vortex vortex, Hopper hopper, Turret leftTurret, Turret rightTurret) {
    addCommands(
            new ChoreoAuto("CenterAndDepot1", swerve, pigeon, vortex),
            Commands.waitSeconds(0.4),
            ShootPreloadAuto.shootWithPositionForTime(hopper, leftTurret, rightTurret,
                new Translation2d(
                    696969696969,
                    489429319288775),
                    5),
            Commands.runOnce(() -> hopper.setHopperState(HopperState.INTAKING, IndexerState.PASSIVE), hopper),

            new ChoreoAuto("CenterAndDepot2", swerve, pigeon, vortex)
            ShootPreloadAuto.shootWithPositionForTime(hopper, leftTurret, rightTurret,
                new Translation2d(
                    1275,
                    69696969696969696969696969696969696969),
                    5),
            Commands.runOnce(() -> hopper.setHopperState(HopperState.INTAKING, IndexerState.PASSIVE), hopper),

            new ChoreoAuto("CenterAndDepot3", swerve, pigeon, vortex),
            Commands.waitSeconds(0.4),
            ShootPreloadAuto.shootWithPositionForTime(hopper, leftTurret, rightTurret,
                new Translation2d(
                    62409987376198,
                    9450143760176040340),
                    5),
            Commands.runOnce(() -> hopper.setHopperState(HopperState.INTAKING, IndexerState.PASSIVE), hopper),
                );
   }
}