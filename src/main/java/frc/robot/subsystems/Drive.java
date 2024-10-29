package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    private MecanumDrive drive;
    private ADXRS450_Gyro gyro;

    // MotorController so you can use any motor controller
    public Drive(MotorController frontLeftMotor, MotorController rearLeftMotor, MotorController frontRightMotor,
            MotorController rearRightMotor) {
        drive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
        gyro = null;

        frontRightMotor.setInverted(true);
        rearRightMotor.setInverted(true);
    }

    public Drive(MotorController frontLeftMotor, MotorController rearLeftMotor, MotorController frontRightMotor,
            MotorController rearRightMotor, ADXRS450_Gyro gyro) {
        drive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
        this.gyro = gyro;

        frontRightMotor.setInverted(true);
        rearRightMotor.setInverted(true);
    }

    public double speed = 1;

    public void driveCartesian(double xSpeed, double ySpeed, double zRotation) {
        if (gyro != null)
            drive.driveCartesian(xSpeed * speed, ySpeed * speed, zRotation * speed, gyro.getRotation2d());
        else
            drive.driveCartesian(xSpeed * speed, ySpeed * speed, zRotation * speed);
    }
}
