package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Blocker;
import static frc.robot.commands.Unblock.time;


public class Block extends CommandBase {
    private final Blocker blocker = Blocker.getInstance();
    public Block() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.blocker);
    }

    @Override
    public void initialize() {
        blocker.block();
    }

    @Override
    public void execute() {
        time--;
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return time <= 0;
    }

    @Override
    public void end(boolean interrupted) {
        blocker.stop();
    }
}
