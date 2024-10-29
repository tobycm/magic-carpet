package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class RotateLeft extends Command {
    private Drive drive;
    private double duration;
    private double endTime;

    public RotateLeft(double duration, Drive drive) {
        this.drive = drive;
        this.duration = duration;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        endTime = Timer.getFPGATimestamp() + duration;
    }

    @Override
    public void execute() {
        drive.driveCartesian(0, 0, -1);
    }

    @Override
    public void end(boolean interrupted) {
        drive.driveCartesian(0, 0, 0);
    }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() >= endTime;
    }
}
