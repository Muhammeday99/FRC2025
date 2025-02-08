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

  private final Joystick joystick = new Joystick(0);

  public RobotContainer() {
      configureBindings();
      drivetrainSubsystem.setDefaultCommand(new ArcadeDriveCommand(drivetrainSubsystem, () -> -joystick.getRawAxis(1), () -> joystick.getRawAxis(0)));
  }

  public DrivetrainSubsystem getDriveTrain(){
    return drivetrainSubsystem;
  }

  private void configureBindings() {
      // Define controller button bindings here
      new JoystickButton(joystick, 3).whileTrue(new ElevatorJoystickCommand(elevatorSubsystem, 0.5));
      new JoystickButton(joystick, 4).whileTrue(new ElevatorJoystickCommand(elevatorSubsystem, -0.5));
  }

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new DriveForwardCommand(drivetrainSubsystem, 2, new Timer()),
      new ElevatorJoystickCommand(elevatorSubsystem, 0.5)
    );
  }
}