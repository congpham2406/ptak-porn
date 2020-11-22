package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Spinner;


public class SpinToTarget extends CommandBase {
    private final Spinner spinner = Spinner.getInstance();

    public SpinToTarget() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.spinner);
    }

    Color target;

    @Override
    public void initialize() {
        target = spinner.getTarget();
        spinner.spin(0.2);
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return spinner.getCurrent() == spinner.getTarget();
    }

    @Override
    public void end(boolean interrupted) {
        spinner.spin(0);
    }
}
