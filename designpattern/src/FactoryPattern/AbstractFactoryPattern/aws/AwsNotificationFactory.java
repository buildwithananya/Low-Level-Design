package FactoryPattern.AbstractFactoryPattern.aws;

import FactoryPattern.AbstractFactoryPattern.NotificationAbstractFactory;
import FactoryPattern.WithoutFactoryPattern.Notification;

public class AwsNotificationFactory implements NotificationAbstractFactory 
{
	@Override
	public Notification createEmailNotification()
	{
		return new AwsEmailNotification();
	}
	
	@Override
	public Notification createSMSNotification()
	{
		return new AwsSMSNotification();
	}
	
	@Override
	public Notification createPushNotification()
	{
		return new AwsPushNotification();
	}
}
