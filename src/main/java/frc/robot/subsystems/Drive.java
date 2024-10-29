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
        rearRightMotor.setInverted(true);

        frontLeftMotor.follow(rearLeftMotor);
        frontRightMotor.follow(rearRightMotor);

        drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
    }

    public double speed = 0.1;

    public void curvatureDrive(double xSpeed, double zRotation) {
        drive.curvatureDrive(xSpeed, zRotation, false);
    }
}
