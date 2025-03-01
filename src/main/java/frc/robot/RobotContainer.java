package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.DriveForwardCommand;
import frc.robot.commands.ElevatorJoystickCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RobotContainer {
  
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  private final Joystick joystick = new Joystick(Constants.OperatorConstants.kJoystickPort);

  public RobotContainer() {
      configureBindings();
      drivetrainSubsystem.setDefaultCommand(new ArcadeDriveCommand(drivetrainSubsystem, 
          () -> -joystick.getRawAxis(1), // Left stick Y-axis for forward/backward
          () -> joystick.getRawAxis(4)   // Right stick X-axis for rotation
      ));
  }

  public DrivetrainSubsystem getDriveTrain(){
    return drivetrainSubsystem;
  }

  private void configureBindings() {
      // Define controller button bindings here
      new JoystickButton(joystick, Constants.OperatorConstants.kElevatorUpButton).whileTrue(new ElevatorJoystickCommand(elevatorSubsystem, 0.5));
      new JoystickButton(joystick, Constants.OperatorConstants.kElevatorDownButton).whileTrue(new ElevatorJoystickCommand(elevatorSubsystem, -0.5));
  }

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new DriveForwardCommand(drivetrainSubsystem, 2, new Timer()),
      new ElevatorJoystickCommand(elevatorSubsystem, 0.5)
    );
  }
}