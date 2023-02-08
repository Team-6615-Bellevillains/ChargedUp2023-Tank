package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.MotorBoxConstants;

public class MotorBox {

    private int idx;

    private Spark frontMotor, backMotor;
    private Encoder frontMotorEncoder, backMotorEncoder;
    private PIDController speedController;

    public MotorBox(int idx, int frontMotorPort, int backMotorPort, int[] frontMotorEncoderPorts,
            int[] backMotorEncoderPorts,
            boolean motorsInverted, boolean encodersInverted) {

        this.idx = idx;

        frontMotor = new Spark(frontMotorPort);
        backMotor = new Spark(backMotorPort);

        frontMotor.setInverted(motorsInverted);
        backMotor.setInverted(motorsInverted);

        frontMotorEncoder = new Encoder(frontMotorEncoderPorts[0], frontMotorEncoderPorts[1]);
        backMotorEncoder = new Encoder(backMotorEncoderPorts[0], backMotorEncoderPorts[1]);

        frontMotorEncoder
                .setDistancePerPulse(MotorBoxConstants.kDriveEncoderCounts2Meter);
        backMotorEncoder
                .setDistancePerPulse(MotorBoxConstants.kDriveEncoderCounts2Meter);

        frontMotorEncoder.setReverseDirection(encodersInverted);
        backMotorEncoder.setReverseDirection(encodersInverted);

        speedController = new PIDController(.05, 0, 0);

    }

    private String appendIdx(String input) {
        return String.format("[%s] %s", idx, input);
    }

    public void set(double speed) {
        double pidOutput = speedController.calculate((frontMotorEncoder.getRate() + backMotorEncoder.getRate()) / 2,
                speed);

        SmartDashboard.putNumber(appendIdx("Speed Output"), pidOutput);

        frontMotor.set(pidOutput);
        backMotor.set(pidOutput);
    }

    public void stop() {
        frontMotor.set(0);
        backMotor.set(0);
    }

}
