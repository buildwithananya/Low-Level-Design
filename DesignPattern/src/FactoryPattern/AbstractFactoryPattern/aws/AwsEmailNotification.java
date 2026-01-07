package FactoryPattern.AbstractFactoryPattern.aws;

import FactoryPattern.WithoutFactoryPattern.Notification;

public class AwsEmailNotification implements Notification
{
	@Override
    public void notifyUser() 
	{
        System.out.println("Sending AWS EMAIL notification");
    }

    @Override
    public String getNotificationType() 
    {
        return "EMAIL";
    }

    @Override
    public void scheduleNotification(int delayInSeconds) 
    {
        System.out.println("AWS EMAIL notification scheduled in " + delayInSeconds + " seconds");
    }
}
