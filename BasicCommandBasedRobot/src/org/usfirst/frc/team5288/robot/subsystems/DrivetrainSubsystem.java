package org.usfirst.frc.team5288.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
import org.usfirst.frc.team5288.robot.RobotMap;
import org.usfirst.frc.team5288.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DrivetrainSubsystem extends Subsystem {
	
    //**MOTOR CONTROLLER OBJECTS**
	//These Motor controller objects will always be synced in pairs of output.
     private TalonSRX lDrive1 = new TalonSRX(RobotMap.LDriveMotor1);//Left Gearbox Motor #
     private TalonSRX lDrive2 = new TalonSRX(RobotMap.LDriveMotor2);//Left Gearbox Motor #
     private TalonSRX rDrive1 = new TalonSRX(RobotMap.RDriveMotor1);//Right Gearbox Motor #1
     private TalonSRX rDrive2 = new TalonSRX(RobotMap.RDriveMotor2);//Right Gearbox Motor #2
	//**Drive Variables**
      private double throttle = 1;
	  private double lPower = 0;//Raw Power percentage being output to the left gearbox.
	  private double rPower = 0;//Raw Power percentage being output to the right gearbox.
	//**ENCODER VARIABLES**
	  //  private Encoder rEncoder = new Encoder(RobotMap.RDriveEncoder1,RobotMap.RDriveEncoder2,false,Encoder.EncodingType.k2X);
	  // private Encoder lEncoder = new Encoder(RobotMap.LDriveEncoder1,RobotMap.LDriveEncoder2,true,Encoder.EncodingType.k2X);	
	//**SPEED CALCULATION BASED VARIABLES**
	//  public double PreviousTime = 0;
	//  public double currentTime = 0;
    
	//**DriveTrain Methods and Procedures  
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualDrive());
    
    }
    public DrivetrainSubsystem()
    {
        System.out.println("Drivetrain Initializing");
    /*	rEncoder.setMinRate(5);
    	rEncoder.setDistancePerPulse(18.85/360);
    	rEncoder.setSamplesToAverage(1);
    	lEncoder.setMinRate(5);
    	lEncoder.setDistancePerPulse(18.85/360);
    	lEncoder.setSamplesToAverage(1);*/
    }
    public void testInit()
    {
     	/*rEncoder.startLiveWindowMode();
    	lEncoder.startLiveWindowMode();
  */ 
    }
    //**Throttle is used to maximize the output potential by the MANUAL driver
    //TODO: Implement Throttle
    public void setThrottle(double newThrottle)
    {
    	throttle = newThrottle;
    }
    public double getThrottle(){
    	return throttle;
    }
    
    public void setLPower(double power)
	{
    	lDrive1.set(-power);
		lDrive2.set(-power);
		lPower = power;
	}
    public void setRPower(double power)
	{
    	rDrive1.set(power);
		rDrive2.set(power);
		rPower = power;
	}
  /*  public double getLEncoderDistance()
	{
		return lEncoder.getDistance();
	}
	
	public double getREncoderDistance()
	{
		return rEncoder.getDistance();
	}
	public void resetEncoders()//Should not need to be used except when changing control periods.
	{
		lEncoder.reset();
		rEncoder.reset();
	}*/
}

