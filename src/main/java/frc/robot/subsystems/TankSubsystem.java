package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.MotorBox;

public class TankSubsystem extends SubsystemBase {

    private MotorBox leftMotorBox = new MotorBox(0, 1, new int[] { 6, 7 }, new int[] { 4, 5 }, true, false);
    private MotorBox rightMotorBox = new MotorBox(2, 3, new int[] { 2, 3 }, new int[] { 0, 1 }, false, false);

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
