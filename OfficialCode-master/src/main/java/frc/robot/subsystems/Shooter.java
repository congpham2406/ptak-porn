package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SHOOTER_CONST.LEFT_SHOOTER_CAN;
import static frc.robot.Constants.SHOOTER_CONST.RIGHT_SHOOTER_CAN;

public class Shooter extends SubsystemBase {
    /**
     * The Singleton instance of this Shooter. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private static Shooter INSTANCE;

    /**
     * Returns the Singleton instance of this Shooter. This static method
     * should be used by external classes, rather than the constructor
     * to get the instance of this class. For example: {@code Shooter.getInstance();}
     */
    public static Shooter getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (Shooter.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new Shooter();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Shooter.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private Shooter() {
        shooterFollow.follow(shooter);
        shooterFollow.setInverted(InvertType.OpposeMaster);
    }

    WPI_TalonSRX shooter = new WPI_TalonSRX(LEFT_SHOOTER_CAN);
    WPI_TalonSRX shooterFollow = new WPI_TalonSRX(RIGHT_SHOOTER_CAN);

    public void shoot(double speed){
        shooter.set(speed);
    }
}

