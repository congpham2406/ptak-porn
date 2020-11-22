package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SHOOTER_CONST.*;

public class Blocker extends SubsystemBase {
    /**
     * The Singleton instance of this Blocker. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private static Blocker INSTANCE;

    /**
     * Returns the Singleton instance of this Blocker. This static method
     * should be used by external classes, rather than the constructor
     * to get the instance of this class. For example: {@code Blocker.getInstance();}
     */
    public static Blocker getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (Blocker.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new Blocker();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Blocker.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private Blocker() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    WPI_TalonSRX blocker = new WPI_TalonSRX(BLOCKER_CAN);

    public void block() {
        blocker.set(-1);
    }

    public void unblock() {
        blocker.set(1);
    }

    public void stop() {
        blocker.stopMotor();
    }
}

