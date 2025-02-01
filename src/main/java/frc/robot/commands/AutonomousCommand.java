package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class AutonomousCommand extends CommandBase {
    private final DifferentialDrive driveTrain;
    private final ElevatorSubsystem elevator;

    public AutonomousCommand(DifferentialDrive driveTrain, ElevatorSubsystem elevator) {
        this.driveTrain = driveTrain;
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        Timer.delay(2); // Wait 2 seconds
        driveTrain.arcadeDrive(0.5, 0); // Move forward at half speed
        Timer.delay(3); // Move for 3 seconds
        driveTrain.arcadeDrive(0, 0); // Stop
        elevator.setElevatorHeight(50); // Raise elevator to 50 units
    }
}