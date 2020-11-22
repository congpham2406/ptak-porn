package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;


public class Shoot extends CommandBase {
    private final Shooter shooter = Shooter.getInstance();

    public Shoot() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.shooter);
    }

    @Override
    public void initialize() {
        shooter.shoot(1);
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
        shooter.shoot(0);
    }
}
