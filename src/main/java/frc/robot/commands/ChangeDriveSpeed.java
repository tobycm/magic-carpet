package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class ChangeDriveSpeed extends Command {
    private final XboxController controller;
    private final Drive drive;

    public ChangeDriveSpeed(Drive drive, XboxController controller) {
        this.drive = drive;
        this.controller = controller;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.speed = Math.round((drive.speed + (controller.getLeftBumper() ? -0.1 : 0.1)) * 10) / 10d;

        if (drive.speed > 1)
            drive.speed = 1;
        if (drive.speed < 0)
            drive.speed = 0;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
