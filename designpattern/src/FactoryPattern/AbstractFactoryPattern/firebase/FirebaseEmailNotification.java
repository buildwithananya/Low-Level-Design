package FactoryPattern.AbstractFactoryPattern.firebase;

import FactoryPattern.WithoutFactoryPattern.Notification;

public class FirebaseEmailNotification implements Notification
{
	@Override
    public void notifyUser() 
	{
        System.out.println("Sending Firebase EMAIL notification");
    }

    @Override
    public String getNotificationType() 
    {
        return "EMAIL";
    }

    @Override
    public void scheduleNotification(int delayInSeconds) 
    {
        System.out.println("Firebase EMAIL notification scheduled in " + delayInSeconds + " seconds");
    }
}
