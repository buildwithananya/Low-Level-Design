package FactoryPattern.AbstractFactoryPattern.aws;

import FactoryPattern.WithoutFactoryPattern.Notification;

public class AwsSMSNotification implements Notification
{
    @Override
    public void notifyUser() {
        System.out.println("Sending AWS SMS notification");
    }

    @Override
    public String getNotificationType() {
        return "SMS";
    }

    @Override
    public void scheduleNotification(int delayInSeconds) {
        System.out.println("AWS SMS notification scheduled in " + delayInSeconds + " seconds");
    }
}
