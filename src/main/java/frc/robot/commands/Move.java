// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Joystick;
import frc.robot.subsystems.Drive;

/** An example command that uses an example subsystem. */
public class Move extends Command {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private Drive drive;
  private Joystick joystick;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Move(Drive drive, Joystick joystick) {
    this.drive = drive;
    this.joystick = joystick;

    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.curvatureDrive(joystick.getY(), -joystick.getX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.curvatureDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
