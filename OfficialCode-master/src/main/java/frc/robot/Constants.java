/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.commands.Intake;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DRIVE_CONST {
        public static final int
                LEFT_ENCODED_CAN = 1,
                LEFT_FOLLOW_CAN = 2,
                RIGHT_ENCODED_CAN = 3,
                RIGHT_FOLLOW_CAN = 4;
    }

    public static final class SHOOTER_CONST {
        public static final int
                LEFT_SHOOTER_CAN = 5,
                RIGHT_SHOOTER_CAN = 6,
                BLOCKER_CAN = 7,
                ANGLER_CAN = 8,
        // TODO: Correct this
                SUCKER_CAN = 0;
    }

    public static final class CLIMBER_CONST {
        public static final int
                LEFT_HOOKER_CAN = 9,
                RIGHT_HOOKER_CAN = 10,
        // TODO: Correct this
                HIGH_SWITCH_DIO = 0,
                LOW_SWITCH_DIO = 1;
    }

    public static final class CONTROLLER_CONST {
        public static final int
                GAMEPAD_ID = 0,
                JOYSTICK_ID = 1;
        public static final int[]
                // yo yeet lmaoo
                SHOOTING_BUTTON = {JOYSTICK_ID, 2},
                INTAKE_BUTTON = {GAMEPAD_ID, 5},
                OUTTAKE_BUTTON = {GAMEPAD_ID, 4},
                CLIMB_BUTTON = {JOYSTICK_ID, 4},
                DROP_BUTTON = {JOYSTICK_ID, 6},
                ANGLE_UP_BUTTON = {JOYSTICK_ID, 5},
                ANGLE_DOWN_BUTTON = {JOYSTICK_ID, 3},
                UNBLOCK_BUTTON = {JOYSTICK_ID, 7},
                BLOCK_BUTTON = {JOYSTICK_ID, 8},
                SPIN_COLOR = {JOYSTICK_ID, 9},
                SPIN_LAPS = {JOYSTICK_ID, 10};

    }

    public static final class SPINNER_CONST {
        public static final int laps = 4;
        public static final int SPINNER_CAN = 11;
        public static final I2C.Port i2cPort = I2C.Port.kOnboard;
        public static final ColorMatch m_colorMatcher = new ColorMatch();
        public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
        public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
        public static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
        public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

        static {
            m_colorMatcher.addColorMatch(kBlueTarget);
            m_colorMatcher.addColorMatch(kGreenTarget);
            m_colorMatcher.addColorMatch(kRedTarget);
            m_colorMatcher.addColorMatch(kYellowTarget);
        }
    }

}
