package org.usfirst.frc.team5288.robot.commands;

import org.usfirst.frc.team5288.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualDrive extends Command {
	final double SafeZone = 0.15;
	double joystick1X = 0;
	double joystick2X = 0;
	double joystick1Y = 0;
	double joystick2Y = 0;
    public ManualDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.setLPower(0);
    	Robot.drivetrainSubsystem.setRPower(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Update joystick inputs
    	joystick1X = Robot.oi.getXLX();
    	joystick1Y = -Robot.oi.getXLY();
    	joystick2X = Robot.oi.getXRX();
    	joystick2Y = -Robot.oi.getXRY();
    	if(Math.abs(joystick1Y) >SafeZone){
    		Robot.drivetrainSubsystem.setLPower(joystick1Y*Robot.oi.getThrottle());
    	}
    	else
    	{
        	Robot.drivetrainSubsystem.setLPower(0);
    	}
    	if(Math.abs(joystick2Y)> SafeZone){
    		Robot.drivetrainSubsystem.setRPower(joystick2Y*Robot.oi.getThrottle());
    	}
    	else
    	{
        	Robot.drivetrainSubsystem.setRPower(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
