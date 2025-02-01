package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;

public class RobotContainer {
  private final SparkMax leftFrontMotor = new SparkMax(1, MotorType.kBrushed);
  private final SparkMax leftRearMotor = new SparkMax(2, MotorType.kBrushed);
  private final SparkMax rightFrontMotor = new SparkMax(3, MotorType.kBrushed);
  private final SparkMax rightRearMotor = new SparkMax(4, MotorType.kBrushed);
  
  private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftFrontMotor, leftRearMotor);
  private final MotorControllerGroup rightMotors = new MotorControllerGroup(rightFrontMotor, rightRearMotor);
  
  private final DifferentialDrive driveTrain = new DifferentialDrive(leftMotors, rightMotors);
  
  private final SparkMax elevatorMotor = new SparkMax(5, MotorType.kBrushed);
  private final DigitalInput lowerLimitSwitch = new DigitalInput(0);
  private final DigitalInput upperLimitSwitch = new DigitalInput(1);

  public RobotContainer() {
      configureBindings();
  }

  public DifferentialDrive getDriveTrain(){
    return driveTrain;
  }

  private void configureBindings() {
      // Define controller button bindings here
  }

  public Command getAutonomousCommand() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAutonomousCommand'");
  }
}