package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import static frc.robot.Constants.CLIMBER_CONST.*;

public class Hooker extends SubsystemBase {
    /**
     * The Singleton instance of this Hooker. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private static Hooker INSTANCE;

    /**
     * Returns the Singleton instance of this Hooker. This static method
     * should be used by external classes, rather than the constructor
     * to get the instance of this class. For example: {@code Hooker.getInstance();}
     */
    public static Hooker getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (Hooker.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new Hooker();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Hooker.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private Hooker() {
        hookerFollow.follow(hooker);
        hookerFollow.setInverted(InvertType.OpposeMaster);
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    WPI_TalonSRX hooker = new WPI_TalonSRX(LEFT_HOOKER_CAN);
    WPI_TalonSRX hookerFollow = new WPI_TalonSRX(RIGHT_HOOKER_CAN);
    DigitalInput highSwitch = new DigitalInput(HIGH_SWITCH_DIO);
    DigitalInput lowSwitch = new DigitalInput(LOW_SWITCH_DIO);

    @Override
    public void periodic() {
        if (RobotContainer.gamepad.getRawButton(12)) {
            hook();
        }
        else if (RobotContainer.gamepad.getRawButton(11)) {
            drop();
        } else {
            stop();
        }
    }

    public void hook() {
        hooker.set(1);
    }

    public void drop() {
        hooker.set(-1);
    }

    public void stop() {
        hooker.stopMotor();
    }

    public boolean canGoDown() {
        return !lowSwitch.get();
    }

    public boolean canGoUp() {
        return !highSwitch.get();
    }
}

