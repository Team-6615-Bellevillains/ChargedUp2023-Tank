package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.MotorBox;

public class TankSubsystem extends SubsystemBase {

    private MotorBox leftMotorBox = new MotorBox(0, 0, null, null, false, false);
    private MotorBox rightMotorBox = new MotorBox(0, 0, null, null, false, false);

    public TankSubsystem() {

    }

    public void setBoxSpeeds(double[] speeds) {
        leftMotorBox.set(speeds[0]);
        rightMotorBox.set(speeds[1]);
    }

    public void stopBoxes() {
        leftMotorBox.stop();
        rightMotorBox.stop();
    }

}
