package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Angler;


public class AngleDown extends CommandBase {
    private final Angler angler = Angler.getInstance();

    public AngleDown() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.angler);
    }

    @Override
    public void initialize() {
        angler.down();
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
        angler.stop();
    }
}
