package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hooker;


public class Drop extends CommandBase {
    private final Hooker hooker = Hooker.getInstance();

    public Drop() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.hooker);
    }

    @Override
    public void initialize() {
        hooker.drop();
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return !hooker.canGoDown();
    }

    @Override
    public void end(boolean interrupted) {
//        hooker.stop();
    }
}
