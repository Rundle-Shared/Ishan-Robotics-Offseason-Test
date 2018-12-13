/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6351.robot;


import org.usfirst.frc.team6351.robot.commands.DifferentialDriveArcade;
import org.usfirst.frc.team6351.robot.commands.LimelightCndtl;
import org.usfirst.frc.team6351.robot.commands.LimelightConditional;
import org.usfirst.frc.team6351.robot.commands.LimelightTurning;
import org.usfirst.frc.team6351.robot.commands.LimelightTurningNew;
import org.usfirst.frc.team6351.robot.commands.Rumble;
import org.usfirst.frc.team6351.robot.commands.TriggerDrive;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick xBoxController = new Joystick(1);
	public Joystick secondaryController = new Joystick(0);
	public Joystick bigJoystick = new Joystick(2);

	public Button xBoxA = new JoystickButton(xBoxController, RobotMap.Controller1_A_Button);
	public Button xBoxB = new JoystickButton(xBoxController, RobotMap.Controller1_B_Button);
	public Button xBoxX = new JoystickButton(xBoxController, RobotMap.Controller1_X_Button);
	public Button xBoxY = new JoystickButton(xBoxController, RobotMap.Controller1_Y_Button);
	public Button xBoxLeftTrigger = new JoystickButton(xBoxController, RobotMap.Controller1_Left_Trigger);
	public Button xBoxRightTrigger = new JoystickButton(xBoxController, RobotMap.Controller1_Right_Trigger);
	

	public OI() {
		//xBoxA.whileHeld(new LimelightTurningNew());
		//xBoxY.whileHeld(new LimelightCndtl());
		xBoxB.whileHeld(new Rumble("r", 1));
		xBoxX.whileHeld(new Rumble("l", 1));
	
	}
	
	public double driverControllerAxisVaule(int axis) {
		return xBoxController.getRawAxis(axis);

	}

	public double joystickControllerAxisValue(int axis) {
		return bigJoystick.getRawAxis(axis);

	}

	public double joystickPOV(int axis) {
		return bigJoystick.getPOV(axis);

	}
	
	public void setRumbleL(double value) {
		xBoxController.setRumble(GenericHID.RumbleType.kLeftRumble, value);
	}
	public void setRumbleR(double value) {
		xBoxController.setRumble(GenericHID.RumbleType.kRightRumble, value);
	}
}
