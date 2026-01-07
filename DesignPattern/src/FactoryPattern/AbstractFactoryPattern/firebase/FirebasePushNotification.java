package FactoryPattern.AbstractFactoryPattern.firebase;

import FactoryPattern.WithoutFactoryPattern.Notification;

public class FirebasePushNotification implements Notification
{
	@Override
    public void notifyUser() {
        System.out.println("Sending Firebase PUSH notification");
    }

    @Override
    public String getNotificationType() {
        return "PUSH";
    }

    @Override
    public void scheduleNotification(int delayInSeconds) {
        System.out.println("Firebase PUSH scheduled in " + delayInSeconds + " seconds");
    }
}
