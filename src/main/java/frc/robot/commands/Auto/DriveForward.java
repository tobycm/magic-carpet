package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class DriveForward extends Command {
    private Drive drive;
    private double duration;
    private double endTime;
    private double speed;

    public DriveForward(double duration, Drive drive) {
        this.drive = drive;
        this.duration = duration;
        this.speed = 0.75;

        addRequirements(drive);
    }

    public DriveForward(double duration, Drive drive, double speed) {
        this.drive = drive;
        this.duration = duration;
        this.speed = speed;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        endTime = Timer.getFPGATimestamp() + duration;
    }

    @Override
    public void execute() {
        drive.driveCartesian(-speed, 0, 0);
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
