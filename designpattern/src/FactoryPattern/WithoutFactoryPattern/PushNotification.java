package FactoryPattern.WithoutFactoryPattern;

public class PushNotification implements Notification
{
	@Override
	public void notifyUser()
	{
		System.out.println("Sending PUSH notification");
	}
	@Override
	public String getNotificationType()
	{
		return "PUSH";
	}
	@Override
	public void scheduleNotification(int delayInSeconds)
	{
		System.out.println("PUSH notification scheduled in " + delayInSeconds + " seconds");
	}
}
