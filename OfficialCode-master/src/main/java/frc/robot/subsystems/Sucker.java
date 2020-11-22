package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SHOOTER_CONST.*;

public class Sucker extends SubsystemBase {
    /**
     * The Singleton instance of this Sucker. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private static Sucker INSTANCE;

    /**
     * Returns the Singleton instance of this Sucker. This static method
     * should be used by external classes, rather than the constructor
     * to get the instance of this class. For example: {@code Sucker.getInstance();}
     */
    public static Sucker getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (Sucker.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new Sucker();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Sucker.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private Sucker() {

        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    PWMVictorSPX sucker = new PWMVictorSPX(SUCKER_CAN);

    public void set(double speed) {
        sucker.set(speed);
    }

    public void suck() {
        set(0.5);
    }

    public void spit() {
        set(-0.5);
    }

    public void stop() {
        set(0);
    }
}

