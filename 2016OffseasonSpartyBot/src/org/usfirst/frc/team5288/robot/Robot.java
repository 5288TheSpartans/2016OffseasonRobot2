
package org.usfirst.frc.team5288.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5288.robot.commands.*;
import org.usfirst.frc.team5288.robot.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//Main class that controls all of the seperate objects.
	/*Camera
	private int session;
	private Image frame;*/
	//Declare subsystems - ShooterArm, Drivetrain, ShooterCannon(Cannon)
	//All Subsystems end with the suffix "Subsystem"
	public static  ShooterArmSubsystem shooterArmSubsystem;
	public static  CannonSubsystem cannonSubsystem;
	public static  DrivetrainSubsystem drivetrainSubsystem;

	//Operator interface
	public static OI oi;
	//Camera Variables
    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	System.out.println("Robot(Initialise): Robot Code Has Started");
    	
    	//Initialising subsystems
    	shooterArmSubsystem = new ShooterArmSubsystem();
    	drivetrainSubsystem = new DrivetrainSubsystem();
    	cannonSubsystem = new CannonSubsystem();
    	
    	//Initialising OI
		oi = new OI();
		
	/*	//CAMERA INIT
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		//the camera name (ex "cam0") can be found through the roborio web interface
		session = NIVision.IMAQdxOpenCamera("cam1",NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(session); 
  	  	NIVision.IMAQdxStartAcquisition(session);
     */
		//Autonomous Code initialization and selection creation.
        chooser = new SendableChooser();
        //chooser.addDefault("Default Auto", new ());
        //chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
    	//Updates smartDashboard once to ensure all variables have base values
        System.out.println("Robot(Initialise): Robot Initialization complete.");
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		grabCamera();
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
 
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	grabCamera();
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	grabCamera();
    	Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	grabCamera();
        LiveWindow.run();
    }
    
    public void updateSmartDashboard(boolean driveupdate, boolean armUpdate, boolean cannonOpdate, boolean operatorUpdate){
    	
    }
    public void grabCamera()
    {


          /**
           * grab an image, draw the circle, and provide it for the camera server
           * which will in turn send it to the dashboard.
           */
          //NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
          /*    NIVision.IMAQdxGrab(session, frame, 1);
              CameraServer.getInstance().setImage(frame);
			*/
              /** robot code here! **/
         // NIVision.IMAQdxStopAcquisition(session);
          

    }

}
