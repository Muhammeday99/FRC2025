package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends Command{
    private final DrivetrainSubsystem m_subsystem;
    private final Supplier<Double> speedFunction, turnFunction;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDriveCommand(DrivetrainSubsystem subsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.m_subsystem = subsystem;
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ArcadeDriveCommand initialized");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    double left = realTimeSpeed + realTimeTurn;
    double right = realTimeSpeed - realTimeTurn;

    m_subsystem.setMotors(left, right);

    System.out.println("ArcadeDriveCommand execute: " + left + " " + right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.setMotors(0,0);
    System.out.println("ArcadeDriveCommand ended: " + interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

