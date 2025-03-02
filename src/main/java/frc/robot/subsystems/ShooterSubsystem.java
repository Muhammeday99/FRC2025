package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkMax;

import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase{
    private final SparkMax shooterMotor = new SparkMax(Constants.SparkMaxConstants.kShooterSparkMaxID, MotorType.kBrushless);

    public void setMotors(double speed){
        shooterMotor.set(speed);
    }
}
