// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Move;
import frc.robot.subsystems.Drive;

@SuppressWarnings("resource")

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // lmao broken indentation

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the trigger bindings
        configureBindings();
    }

    // The robot's subsystems and commands are defined here...
    private Drive drive = new Drive(new WPI_VictorSPX(DriveConstants.frontLeftMotorPort),
            new WPI_VictorSPX(DriveConstants.rearLeftMotorPort),
            new WPI_VictorSPX(DriveConstants.frontRightMotorPort),
            new WPI_VictorSPX(DriveConstants.rearRightMotorPort));

    private final Joystick joystick = new Joystick(OperatorConstants.driveRobotJoystickPort);

    // private final NintendoController shooterController = new NintendoController(
    // OperatorConstants.shooterControllerPort);

    /**
     * Use this method to define your trigger->command mappings. Triggers can be
     * created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
     * an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
     * {@link
     * CommandXboxController
     * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or
     * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings() {
        new Trigger(() -> joystick.getXAxis() != 0.0 || joystick.getYAxis() != 0.0)
                .whileTrue(new Move(drive, joystick));

    }

    // run any periodic code here
    public void tick() {
        if (joystick.getBetterThrottle() != drive.speed) {
            // drive.speed = joystick.getBetterThrottle();
        }
    }

    public Command getAutonomousCommand() {
        return null;
    }

}
