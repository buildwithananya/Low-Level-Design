package FactoryPattern.AbstractFactoryPattern.aws;

import FactoryPattern.WithoutFactoryPattern.Notification;

public class AwsPushNotification implements Notification
{
	@Override
	public void notifyUser()
	{
		System.out.println("Sending AWS PUSH notification");
	}
	
	@Override
	public String getNotificationType()
	{
		return "PUSH";
	}
	
	@Override
    public void scheduleNotification(int delayInSeconds) {
        System.out.println("AWS PUSH notification scheduled in " + delayInSeconds + " seconds");
    }
}
