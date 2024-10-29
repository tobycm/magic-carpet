// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public class XboxController extends edu.wpi.first.wpilibj.XboxController {
  public XboxController(int controllerPort) {
    super(controllerPort);
  }

  public static double leftDeadZone = 0.1;
  public static double rightDeadZone = 0.1;

  @Override
  public double getLeftX() {
    return applyDeadzone(super.getLeftX(), leftDeadZone);
  }

  @Override
  public double getLeftY() {
    return applyDeadzone(super.getLeftY(), leftDeadZone);
  }

  @Override
  public double getRightX() {
    return applyDeadzone(super.getRightX(), rightDeadZone);
  }

  @Override
  public double getRightY() {
    return applyDeadzone(super.getRightY(), rightDeadZone);
  }

  // applys deadzone because of stickdrift
  public static double applyDeadzone(double value, double deadzone) {
    if (value < deadzone && value > -deadzone)
      value = 0.0;
    return value;
  }
}