package FactoryPattern.WithoutFactoryPattern;

public interface Notification 
{
	void notifyUser();              // send immediately
    String getNotificationType();   // return type (EMAIL, SMS, PUSH)
    void scheduleNotification(int delayInSeconds);  // schedule notification
}
