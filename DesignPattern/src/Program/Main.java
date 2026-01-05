package Program;

import FactoryPattern.WithFactoryPattern.NotificationFactory;
import FactoryPattern.WithoutFactoryPattern.EmailNotification;
import FactoryPattern.WithoutFactoryPattern.Notification;
import FactoryPattern.WithoutFactoryPattern.PushNotification;
import FactoryPattern.WithoutFactoryPattern.SMSNotification;
import Singleton.Logger;

public class Main {

	public static void main(String[] args) 
	{
		//Singleton Design Pattern
		Logger logger1 = Logger.getInstance();
	    Logger logger2 = Logger.getInstance();//Instance is not created as existing logger instance already exists
	
	    logger1.log("Application started");
	    logger2.log("Processing data");
	    logger1.info("Server started");
	    logger2.debug("User authenticated");
	    logger1.error("Database connection failed");
	
	    System.out.println(logger1 == logger2); // true
	    
	    //Without Factory Pattern
	    
	    // Client knows about concrete classes-tight coupling
	    //Violates Open Closed Principle
        Notification email = new EmailNotification();
        email.notifyUser();

        Notification sms = new SMSNotification();
        sms.notifyUser();

        Notification push = new PushNotification();
        push.notifyUser();
        
        // With Factory Pattern
        Notification emailFactory = NotificationFactory.createNotification("EMAIL");
        emailFactory.notifyUser();
        emailFactory.scheduleNotification(10);
        System.out.println("Type: " + emailFactory.getNotificationType());

        Notification smsFactory = NotificationFactory.createNotification("SMS");
        smsFactory.notifyUser();
        smsFactory.scheduleNotification(5);
        System.out.println("Type: " + smsFactory.getNotificationType());

        Notification pushFactory = NotificationFactory.createNotification("PUSH");
        pushFactory.notifyUser();
        pushFactory.scheduleNotification(15);
        System.out.println("Type: " + pushFactory.getNotificationType());
	}

}
