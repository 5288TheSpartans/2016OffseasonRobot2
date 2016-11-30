package org.usfirst.frc.team5288.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	// Drivetrain motors
	public static int LDriveMotor1 = 0;
	public static int LDriveMotor2 = 1;
	public static int RDriveMotor1 = 2;
	public static int RDriveMotor2 = 3;
	// Drivetrain Sensors (D/IO)
	public static int LDriveEncoder1 = 0;
	public static int LDriveEncoder2 = 1;
	public static int RDriveEncoder1 = 2;
	public static int RDriveEncoder2 = 3;
	  //Shooter Subsystem
    public static int LShooter = 4;//The motor that spins the left shooter wheel
    public static int RShooter = 5;//The motor that spins the right shooter wheel
    public static int ShooterServo = 6;//The servo that pushes the ball into the shooter wheel.
    public static int ShooterLift = 7;// The motor that angles the shooter.
    // Shooter (D/IO)
    public static int shooterUpperLimit = 4;//Limit switches
    public static int shooterLowerLimit = 5;//Limit switches
    //XBOX CONTROLLER MAPPINGS
    public static int xboxJLX = 0, xboxJLY = 1, xboxLTrig = 2, xboxRTrig = 3, 
    		xboxJRX = 4, xboxJRY = 5;
   
	// If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
