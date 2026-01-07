package Program;

import FactoryPattern.WithFactoryPattern.NotificationFactory;
import FactoryPattern.WithoutFactoryPattern.EmailNotification;
import FactoryPattern.WithoutFactoryPattern.Notification;
import FactoryPattern.WithoutFactoryPattern.PushNotification;
import FactoryPattern.WithoutFactoryPattern.SMSNotification;

import java.util.Arrays;
import java.util.List;

import FactoryPattern.AbstractFactoryPattern.NotificationAbstractFactory;
import FactoryPattern.AbstractFactoryPattern.aws.AwsNotificationFactory;
import Singleton.Logger;
import StrategyPattern.WithStrategy.Ecommerce.FestivalDiscountStrategy;
import StrategyPattern.WithStrategy.Ecommerce.Orders;
import StrategyPattern.WithStrategy.Ecommerce.PremiumCustomerDiscountStrategy;
import StrategyPattern.WithoutStrategy.Ecommerce.Customer;
import StrategyPattern.WithoutStrategy.Ecommerce.CustomerType;
import StrategyPattern.WithoutStrategy.Ecommerce.Order;
import StrategyPattern.WithoutStrategy.Ecommerce.Product;

public class Main
{
    public static void main(String[] args)
    {
        // ================= Singleton Pattern =================
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance(); // same instance

        logger1.log("Application started");
        logger2.log("Processing data");
        logger1.info("Server started");
        logger2.debug("User authenticated");
        logger1.error("Database connection failed");

        System.out.println(logger1 == logger2); // true


        // ================= Without Factory Pattern =================
        // Tight coupling, violates OCP

        Notification directEmailNotification = new EmailNotification();
        directEmailNotification.notifyUser();

        Notification directSmsNotification = new SMSNotification();
        directSmsNotification.notifyUser();

        Notification directPushNotification = new PushNotification();
        directPushNotification.notifyUser();


        // ================= Simple Factory Pattern =================

        Notification factoryEmailNotification =
                NotificationFactory.createNotification("EMAIL");
        factoryEmailNotification.notifyUser();
        factoryEmailNotification.scheduleNotification(10);
        System.out.println("Type: " + factoryEmailNotification.getNotificationType());

        Notification factorySmsNotification =
                NotificationFactory.createNotification("SMS");
        factorySmsNotification.notifyUser();
        factorySmsNotification.scheduleNotification(5);
        System.out.println("Type: " + factorySmsNotification.getNotificationType());

        Notification factoryPushNotification =
                NotificationFactory.createNotification("PUSH");
        factoryPushNotification.notifyUser();
        factoryPushNotification.scheduleNotification(15);
        System.out.println("Type: " + factoryPushNotification.getNotificationType());


        // ================= Abstract Factory Pattern =================

        NotificationAbstractFactory awsFactory = new AwsNotificationFactory();

        Notification awsPushNotification = awsFactory.createPushNotification();
        awsPushNotification.notifyUser();
        awsPushNotification.scheduleNotification(10);

        Notification awsEmailNotification = awsFactory.createEmailNotification();
        awsEmailNotification.notifyUser();
        
        // ================= Without Strategy Pattern =================
        
        Customer customer = new Customer("Lucy", CustomerType.PREMIUM);
        
        List<Product> products=Arrays.asList(
        		new Product("Notepad",50 ),
        		new Product("Pen",20));
        
        Order order=new Order(products,true,"SAVE10");
        System.out.println("Total Amount: " + order.calculateOrder(customer));
        
        // ================= Strategy Pattern =================
        
        // Festival sale
        Orders orders=new Orders(products);
        orders.setDiscountStrategy(new FestivalDiscountStrategy());
        System.out.println("Festival Total: " + orders.calculateOrder(customer));
        
        // Premium customer discount
        orders.setDiscountStrategy(new PremiumCustomerDiscountStrategy());
        System.out.println("Premium Total: " + orders.calculateOrder(customer));
    }
}
