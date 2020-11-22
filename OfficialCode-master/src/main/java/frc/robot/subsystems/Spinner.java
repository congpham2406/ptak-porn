package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SPINNER_CONST.*;

public class Spinner extends SubsystemBase {
    /**
     * The Singleton instance of this Spinner. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private static Spinner INSTANCE;

    /**
     * Returns the Singleton instance of this Spinner. This static method
     * should be used by external classes, rather than the constructor
     * to get the instance of this class. For example: {@code Spinner.getInstance();}
     */
    public static Spinner getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (Spinner.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new Spinner();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * Creates a new instance of this Spinner.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private Spinner() {
        colorPicker.setDefaultOption("Blue", kBlueTarget);
        colorPicker.addOption("Red", kRedTarget);
        colorPicker.addOption("Green", kGreenTarget);
        colorPicker.addOption("Yellow", kYellowTarget);
        SmartDashboard.putData(colorPicker);
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    SendableChooser<Color> colorPicker = new SendableChooser<>();
    WPI_VictorSPX spinner = new WPI_VictorSPX(SPINNER_CAN);
    ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

    public Color getCurrent() {
        return current;
    }

    Color current;

    public Color getTarget() {
        return colorPicker.getSelected();
    }


    @Override
    public void periodic() {
        Color detectedColor = m_colorSensor.getColor();
        String colorString;
        ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
        current = match.color;

        if (match.color == kBlueTarget) {
            colorString = "Blue";
        } else if (match.color == kRedTarget) {
            colorString = "Red";
        } else if (match.color == kGreenTarget) {
            colorString = "Green";
        } else if (match.color == kYellowTarget) {
            colorString = "Yellow";
        } else {
            colorString = "Unknown";
        }
        /**
         * Open Smart Dashboard or Shuffleboard to see the color detected by the
         * sensor.
         */
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
    }

    public void spin(double speed) {
        spinner.set(speed);
    }
}

