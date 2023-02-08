// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.TankDriveCmd;
import frc.robot.subsystems.TankSubsystem;

public class RobotContainer {

  private TankSubsystem tankSubsystem = new TankSubsystem();

  private Joystick ps4Controller = new Joystick(1);
  private final int leftXAxis = 0;
  private final int leftYAxis = 1;

  public RobotContainer() {

    tankSubsystem.setDefaultCommand(
        new TankDriveCmd(tankSubsystem, () -> -ps4Controller.getRawAxis(leftYAxis),
            () -> -ps4Controller.getRawAxis(leftXAxis)));

    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
