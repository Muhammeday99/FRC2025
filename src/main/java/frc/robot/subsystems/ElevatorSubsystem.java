package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;

public class ElevatorSubsystem extends SubsystemBase {
    private final SparkMax elevatorMotor = new SparkMax(5, MotorType.kBrushed);
    private final DigitalInput lowerLimitSwitch = new DigitalInput(0);
    private final DigitalInput upperLimitSwitch = new DigitalInput(1);
    private final PIDController elevatorPID = new PIDController(0.1, 0, 0);

    private double setpoint = 0.0; // Target height

    public void setElevatorHeight(double height) {
        setpoint = height;
    }

    public void controlElevator() {
        double power = elevatorPID.calculate(elevatorMotor.getEncoder().getPosition(), setpoint);
        
        if ((power < 0 && lowerLimitSwitch.get()) || (power > 0 && upperLimitSwitch.get())) {
            power = 0; // Stop if at limit
        }
        
        elevatorMotor.set(power);
    }
}