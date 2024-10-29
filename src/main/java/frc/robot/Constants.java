// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class OperatorConstants {
        public static final int driveRobotControllerPort = 0;
        public static final int shooterControllerPort = 1;
    }

    public static class DriveConstants {
        public static final int frontLeftMotorPort = 0;
        public static final int rearLeftMotorPort = 1;
        public static final int frontRightMotorPort = 2;
        public static final int rearRightMotorPort = 3;
    }

    public static class ShooterConstants {
        // public static final int intakeMotorPort = 6;
        public static final int holderMotorPort = 6;

        public static final int leftMotorPort = 7;
        public static final int rightMotorPort = 8;

        // public static final int armLeftMotorPort = 8; // on pwm
        // public static final int armRightMotorPort = -1; // 10
    }

    public static class LiftConstants {
        public static final int forwardSolenoidPort = 0; // 0
        public static final int reverseSolenoidPort = 1; // 1

        public static final int pullyMotorPort = 5;
    }
}
