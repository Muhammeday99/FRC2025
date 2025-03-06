// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ElevatorJoystickCommand extends Command {
  private final ElevatorSubsystem m_subsystem;
  private final double speed;

  public ElevatorJoystickCommand(ElevatorSubsystem subsystem, double speed) {
    this.m_subsystem = subsystem;
    this.speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    System.out.println("ElevatorJoystickCommand created with speed: " + this.speed);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ElevatorJoystickCommand initialized");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Executing ElevatorJoystickCommand with speed: " + speed);
    m_subsystem.setMotors(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.setMotors(0);
    System.out.println("ElevatorJoystickCommand ended: " + interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
