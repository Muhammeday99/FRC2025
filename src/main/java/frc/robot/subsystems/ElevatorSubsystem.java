package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;

public class ElevatorSubsystem extends SubsystemBase {
    private final SparkMax elevatorMotor = new SparkMax(Constants.SparkMaxConstants.kElevatorSparkMaxID, MotorType.kBrushed);

    public void setMotors(double speed){
        elevatorMotor.set(speed);
    }
}