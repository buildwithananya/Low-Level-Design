package FactoryPattern.AbstractFactoryPattern.firebase;

import FactoryPattern.WithoutFactoryPattern.Notification;

public class FirebaseSMSNotification implements Notification
{
    @Override
    public void notifyUser() {
        System.out.println("Sending Firebase SMS notification");
    }

    @Override
    public String getNotificationType() {
        return "SMS";
    }

    @Override
    public void scheduleNotification(int delayInSeconds) {
        System.out.println("Firebase SMS notification scheduled in " + delayInSeconds + " seconds");
    }
}
