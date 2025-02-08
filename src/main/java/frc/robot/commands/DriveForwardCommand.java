package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveForwardCommand extends Command{
    private final DrivetrainSubsystem m_subsystem;
    private final double seconds;
    private final Timer timer;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForwardCommand(DrivetrainSubsystem subsystem, double seconds, Timer timer) {
    this.m_subsystem = subsystem;
    this.seconds = seconds;
    this.timer = timer;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("DriveForwardCommand initialized");
    timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    timer.start();
    m_subsystem.setMotors(0.5,0.5);
    System.out.println("DriveForwardCommand execute: " + seconds);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.setMotors(0,0);
    timer.stop();
    System.out.println("DriveForwardCommand ended: " + interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() > seconds){
        return true;
    }
    return false;
  }
}
