package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Joystick;
import frc.robot.subsystems.Drive;

public class ChangeDriveSpeed extends Command {
    private final Joystick joystick;
    private final Drive drive;

    public ChangeDriveSpeed(Drive drive, Joystick joystick) {
        this.drive = drive;
        this.joystick = joystick;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        // drive.speed = joystick.getBetterThrottle();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
