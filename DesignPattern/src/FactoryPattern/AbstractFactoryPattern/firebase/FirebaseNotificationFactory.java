package FactoryPattern.AbstractFactoryPattern.firebase;

import FactoryPattern.AbstractFactoryPattern.NotificationAbstractFactory;
import FactoryPattern.WithoutFactoryPattern.Notification;

public class FirebaseNotificationFactory implements NotificationAbstractFactory
{
    @Override
    public Notification createEmailNotification() {
        return new FirebaseEmailNotification();
    }

    @Override
    public Notification createSMSNotification() {
        return new FirebaseSMSNotification();
    }

    @Override
    public Notification createPushNotification() {
        return new FirebasePushNotification();
    }
}
