package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    private DifferentialDrive drive;

    // MotorController so you can use any motor controller
    public Drive(WPI_VictorSPX frontLeftMotor, WPI_VictorSPX rearLeftMotor, WPI_VictorSPX frontRightMotor,
            WPI_VictorSPX rearRightMotor) {

        frontRightMotor.setInverted(true);
        rearLeftMotor.setInverted(true);

        rearLeftMotor.follow(frontLeftMotor);
        rearRightMotor.follow(frontRightMotor);

        drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

    }

    public double speed = 0.65;

    public void curvatureDrive(double xSpeed, double zRotation) {
        drive.arcadeDrive(xSpeed * speed, zRotation);

    }
}
