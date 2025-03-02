package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase{
    private final SparkMax leftFrontMotor = new SparkMax(Constants.SparkMaxConstants.kLeftFrontSparkMaxID, MotorType.kBrushed);
    private final SparkMax leftRearMotor = new SparkMax(Constants.SparkMaxConstants.kLeftRearSparkMaxID, MotorType.kBrushed);
    private final SparkMax rightFrontMotor = new SparkMax(Constants.SparkMaxConstants.kRightFrontSparkMaxID, MotorType.kBrushed);
    private final SparkMax rightRearMotor = new SparkMax(Constants.SparkMaxConstants.kRightRearSparkMaxID, MotorType.kBrushed);
    SparkMaxConfig configLeft = new SparkMaxConfig();
    SparkMaxConfig configRightLeader = new SparkMaxConfig();
    SparkMaxConfig configRightFollower = new SparkMaxConfig();

    
    private final DifferentialDrive driveTrain = new DifferentialDrive(leftFrontMotor::set, rightFrontMotor::set);

    public DrivetrainSubsystem(){
        configLeft.follow(leftFrontMotor);
        configRightLeader.inverted(true);
        configRightFollower.follow(rightFrontMotor);

        leftRearMotor.configure(configLeft, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFrontMotor.configure(configRightLeader, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightRearMotor.configure(configRightFollower, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setMotors(double leftSpeed, double rightSpeed) {
        driveTrain.setMaxOutput(1);
        driveTrain.arcadeDrive(-leftSpeed, rightSpeed);
    }
    
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Drive Value", 0);
    }

    public DifferentialDrive getDriveTrain() {
        return driveTrain;
    }
}
