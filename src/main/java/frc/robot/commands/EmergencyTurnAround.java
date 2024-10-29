package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class EmergencyTurnAround extends Command {
    private final Drive drive;
    private double endTime;

    public EmergencyTurnAround(Drive drive) {
        this.drive = drive;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        endTime = Timer.getFPGATimestamp() + 0.5;
    }

    @Override
    public void execute() {
        drive.driveCartesian(0, 0, 1);
    }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() >= endTime;
    }
}
