package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Spinner;
import static  frc.robot.Constants.SPINNER_CONST.*;

public class SpinToLaps extends CommandBase {
    private final Spinner spinner = Spinner.getInstance();
    int count;
    Color current;
    boolean hasChanged;

    public SpinToLaps() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.spinner);
    }

    @Override
    public void initialize() {
        count = 0;
        current = spinner.getCurrent();
        hasChanged = false;
    }

    @Override
    public void execute() {
        if(current == spinner.getCurrent() && hasChanged){
            count++;
            hasChanged = false;
        }
        else if(current != spinner.getCurrent()){
            hasChanged = true;
        }
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return count > laps * 2;
    }

    @Override
    public void end(boolean interrupted) {
        spinner.spin(0);
    }
}
