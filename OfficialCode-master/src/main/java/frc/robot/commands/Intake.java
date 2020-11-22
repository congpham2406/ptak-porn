package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Sucker;


public class Intake extends CommandBase {
    private final Sucker sucker = Sucker.getInstance();

    public Intake() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.sucker);
    }

    @Override
    public void initialize() {
        sucker.suck();
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        sucker.stop();
    }
}
