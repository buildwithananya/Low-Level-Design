package FactoryPattern.WithFactoryPattern;
import FactoryPattern.WithoutFactoryPattern.EmailNotification;
import FactoryPattern.WithoutFactoryPattern.Notification;
import FactoryPattern.WithoutFactoryPattern.PushNotification;
import FactoryPattern.WithoutFactoryPattern.SMSNotification;

public class NotificationFactory 
{
	// Factory method: decides which object to create
	public static Notification createNotification(String notificationType)
	{
		if(notificationType==null)
			throw new IllegalArgumentException("Notification type cannot be null");
		
		switch(notificationType.toUpperCase())
		{
			case "EMAIL":
				return new EmailNotification();
			case "SMS":
				return new SMSNotification();
			case "PUSH":
				return new PushNotification();
			default:
                throw new IllegalArgumentException("Unknown notification type: " + notificationType);
		}
	}
}
