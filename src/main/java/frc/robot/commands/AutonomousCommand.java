package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Auto.DriveForward;
import frc.robot.commands.Auto.RotateLeft;
import frc.robot.commands.Auto.RotateRight;
import frc.robot.subsystems.Drive;

public class AutonomousCommand {
    public static class GoStraight extends SequentialCommandGroup {
        public GoStraight(Drive drive) {
            addCommands(new DriveForward(1.3, drive));
            addRequirements(drive);
        }
    }

    public static class Dance extends SequentialCommandGroup {
        public Dance(Drive drive) {
            addCommands(
                    new RotateLeft(0.4, drive),
                    new RotateRight(0.2, drive),
                    new RotateRight(0.3, drive),
                    new RotateLeft(0.1, drive),
                    new WaitCommand(1),
                    new RotateLeft(0.4, drive),
                    new RotateRight(0.2, drive),
                    new RotateRight(0.3, drive),
                    new RotateLeft(0.1, drive));
            addRequirements(drive);
        }
    }

}
