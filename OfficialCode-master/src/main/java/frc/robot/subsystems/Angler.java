package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SHOOTER_CONST.*;

public class Angler extends SubsystemBase {
    /**
     * The Singleton instance of this Angler. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private static Angler INSTANCE;

    /**
     * Returns the Singleton instance of this Angler. This static method
     * should be used by external classes, rather than the constructor
     * to get the instance of this class. For example: {@code Angler.getInstance();}
     */
    public static Angler getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (Angler.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new Angler();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Angler.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private Angler() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    WPI_VictorSPX angler = new WPI_VictorSPX(ANGLER_CAN);

    public void up() {
        angler.set(1);
    }

    public void down() {
        angler.set(-1);
    }

    public void stop()
    {
        angler.stopMotor();
    }

}

