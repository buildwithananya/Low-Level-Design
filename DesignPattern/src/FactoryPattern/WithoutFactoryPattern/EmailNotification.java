package FactoryPattern.WithoutFactoryPattern;

public class EmailNotification implements Notification
{
	@Override
	public void notifyUser()
	{
		System.out.println("Sending email notification");
	}
	@Override
	public String getNotificationType()
	{
		return "EMAIL";
	}
	@Override
	public void scheduleNotification(int delayInSeconds)
	{
		System.out.println("Email notification scheduled in " + delayInSeconds + " seconds");
	}
}
