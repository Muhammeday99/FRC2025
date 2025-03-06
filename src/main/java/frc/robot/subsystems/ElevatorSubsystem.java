package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
    private final SparkMax elevatorMotor = new SparkMax(Constants.SparkMaxConstants.kElevatorSparkMaxID, MotorType.kBrushed);
    private final SparkMax elevatorMotorFollower = new SparkMax(Constants.SparkMaxConstants.kElevatorFollowerSparkMaxID, MotorType.kBrushed);
    SparkMaxConfig configElevator = new SparkMaxConfig();
    
    public ElevatorSubsystem(){
        configElevator.follow(elevatorMotor);

        elevatorMotorFollower.configure(configElevator, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setMotors(double speed){
        elevatorMotor.set(speed);
        elevatorMotorFollower.set(speed);
    }
}