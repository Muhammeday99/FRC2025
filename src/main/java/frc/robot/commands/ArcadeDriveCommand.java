package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends Command {
    private final DrivetrainSubsystem m_subsystem;
    private final Supplier<Double> speedFunction, turnFunction;

    public ArcadeDriveCommand(DrivetrainSubsystem subsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
        this.m_subsystem = subsystem;
        this.speedFunction = speedFunction;
        this.turnFunction = turnFunction;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        System.out.println("ArcadeDriveCommand initialized");
    }

    @Override
    public void execute() {
        double realTimeSpeed = speedFunction.get();
        double realTimeTurn = turnFunction.get();

        m_subsystem.setMotors(realTimeSpeed, realTimeTurn);

        // System.out.println("ArcadeDriveCommand execute: " + realTimeSpeed + " " + realTimeTurn);
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.setMotors(0, 0);
        // System.out.println("ArcadeDriveCommand ended: " + interrupted);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

