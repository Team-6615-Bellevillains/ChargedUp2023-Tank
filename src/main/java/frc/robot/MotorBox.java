package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class MotorBox {

    private Spark frontMotor, backMotor;
    private Encoder frontMotorEncoder, backMotorEncoder;
    private PIDController speedController;

    public MotorBox(int frontMotorPort, int backMotorPort, int[] frontMotorEncoderPorts, int[] backMotorEncoderPorts,
            boolean motorsInverted, boolean encodersInverted) {

        frontMotor = new Spark(frontMotorPort);
        backMotor = new Spark(backMotorPort);

        frontMotor.setInverted(motorsInverted);
        backMotor.setInverted(motorsInverted);

        frontMotorEncoder = new Encoder(frontMotorEncoderPorts[0], frontMotorEncoderPorts[1]);
        backMotorEncoder = new Encoder(backMotorEncoderPorts[0], backMotorEncoderPorts[1]);

        frontMotorEncoder.setReverseDirection(encodersInverted);
        backMotorEncoder.setReverseDirection(encodersInverted);

        speedController = new PIDController(.05, 0, 0);

    }

    public void set(double speed) {
        double pidOutput = speedController.calculate((frontMotorEncoder.getRate() + backMotorEncoder.getRate()) / 2,
                speed);

        frontMotor.set(pidOutput);
        backMotor.set(pidOutput);
    }

    public void stop() {
        frontMotor.set(0);
        backMotor.set(0);
    }

}
