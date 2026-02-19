package Singleton;

public class Logger 
{
	// 1. Create  a static variable to hold one instance of Logger class.
	private static volatile Logger logger;
	 // 2. Create private constructor & it can only be instantiated within this class.
	private Logger() 
	{
		System.out.println("Logger initialized");
	}
	//Step3: Create a static getInstance() method to instantiate the class and also to return an instance of it.
	public static Logger getInstance() 
	{
		if(logger==null)
			logger=new Logger();
		return logger;
	}
	public void log(String message)
	{
		System.out.println("[LOG] " + message);
	}
	public void info(String msg) 
	{
	    System.out.println("[INFO] " + msg);
	}

	public void debug(String msg) 
	{
	    System.out.println("[DEBUG] " + msg);
	}

	public void error(String msg) 
	{
	    System.err.println("[ERROR] " + msg);
	}
}
