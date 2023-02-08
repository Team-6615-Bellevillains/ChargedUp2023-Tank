package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TankSubsystem;

public class TankDriveCmd extends CommandBase {

    private TankSubsystem tankSubsystem;

    private SlewRateLimiter xSpeedLimiter;
    private SlewRateLimiter ySpeedLimiter;

    private Supplier<Double> xSpeedFunction;
    private Supplier<Double> ySpeedFunction;

    public TankDriveCmd(TankSubsystem tankSubsystem, Supplier<Double> xSpeedFunction, Supplier<Double> ySpeedFunction) {
        this.tankSubsystem = tankSubsystem;

        this.xSpeedFunction = xSpeedFunction;
        this.ySpeedFunction = xSpeedFunction;

        this.xSpeedLimiter = new SlewRateLimiter(20);
        this.ySpeedLimiter = new SlewRateLimiter(20);

        addRequirements(tankSubsystem);
    }

    @Override
    public void execute() {
        double xSpeed = xSpeedFunction.get();
        double ySpeed = ySpeedFunction.get();

        xSpeed = Math.abs(xSpeed) > 0.05 ? xSpeed : 0.0;
        ySpeed = Math.abs(ySpeed) > 0.05 ? ySpeed : 0.0;

        xSpeed = xSpeedLimiter.calculate(xSpeed) * 100;
        ySpeed = ySpeedLimiter.calculate(ySpeed) * 100;

        if (Math.abs(xSpeed) > Math.abs(ySpeed)) {
            tankSubsystem.setBoxSpeeds(new double[] { xSpeed, -xSpeed });
        } else {
            tankSubsystem.setBoxSpeeds(new double[] { ySpeed, ySpeed });
        }

    }

    @Override
    public void end(boolean interrupted) {
        tankSubsystem.stopBoxes();
    }

}
