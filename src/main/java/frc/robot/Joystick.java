package frc.robot;

public class Joystick extends edu.wpi.first.wpilibj.Joystick {
    public Joystick(int port) {
        super(port);
    }

    public static double leftDeadZone = 0.1;
    public static double rightDeadZone = 0.1;

    // can't override getX and getY because they are final
    public double getXAxis() {
        return applyDeadzone(super.getX(), leftDeadZone);
    }

    public double getYAxis() {
        return applyDeadzone(super.getY(), leftDeadZone);
    }

    public double getZAxis() {
        return applyDeadzone(super.getZ(), leftDeadZone);
    }

    // applys deadzone because of stickdrift
    public static double applyDeadzone(double value, double deadzone) {
        if (value < deadzone && value > -deadzone)
            value = 0.0;
        return value;
    }

    public double getBetterThrottle() {
        return (super.getTwist() * -1 + 1) / 2;
    }
}
