package FactoryPattern.WithoutFactoryPattern;

public class SMSNotification implements Notification 
{
	@Override
	public void notifyUser()
	{
		System.out.println("Sending SMS notification");
	}
	@Override
	public String getNotificationType()
	{
		return "SMS";
	}
	@Override
	public void scheduleNotification(int delayInSeconds)
	{
		System.out.println("SMS notification scheduled in " + delayInSeconds + " seconds");
	}
}
