package FactoryPattern.AbstractFactoryPattern;

import FactoryPattern.WithoutFactoryPattern.Notification;

public interface NotificationAbstractFactory 
{
	Notification createEmailNotification();
    Notification createSMSNotification();
    Notification createPushNotification();
}
