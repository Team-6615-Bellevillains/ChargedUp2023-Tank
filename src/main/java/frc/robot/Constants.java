package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {

    public static final class MotorBoxConstants {
        public static final double kDrivingWheelCircumference = Units.inchesToMeters(4) * Math.PI; // TODO: Measure
        public static final double kGearRatio = 6.66; // TODO: Measure
        public static final double kCountsPerRotation = 5;

        public static final double kDriveEncoderRot2Meter = kDrivingWheelCircumference / kGearRatio;
        public static final double kDriveEncoderCounts2Meter = kDriveEncoderRot2Meter / kCountsPerRotation;
    }

    public static final class DriveConstants {
        public static final double kTeleOpMaxMotorSpeedMetersPerSecond = 2;
        public static final double kTeleOpMaxMotorAccelerationMetersPerSecondSquared = 0.5;
    }

}
