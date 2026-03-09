package pubsubsystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pubsubsystem.entities.Message;
import pubsubsystem.entities.Topic;
import pubsubsystem.subscriber.Subscriber;

public class PubSubService 
{
	private static final PubSubService INSTANCE=new PubSubService();
	private final Map<String,Topic> topicRegistry;
	private final ExecutorService deliveryExecutor;
	
	private PubSubService()
	{
		this.topicRegistry=new ConcurrentHashMap();
		 // A cached thread pool is suitable for handling many short-lived, bursty tasks (message deliveries).
        deliveryExecutor = Executors.newCachedThreadPool();
	}
	public static PubSubService getInstance()
	{
		return INSTANCE;
	}
	public void createTopic(String topicName)
	{
		topicRegistry.putIfAbsent(topicName, new Topic(topicName,deliveryExecutor));
		System.out.println("Topic " + topicName + " created");
	}
	public void subscribe(String topicName,Subscriber subscriber)
	{
		Topic topic=topicRegistry.get(topicName);
		if(topic==null)
			throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.addSubscribers(subscriber);
        System.out.println("Subscriber '" + subscriber.getId() + "' subscribed to topic: " + topicName);
	}
	public void unsubscribe(String topicName, Subscriber subscriber)
	{
        Topic topic = topicRegistry.get(topicName);
        if (topic != null)
            topic.removeSubscriber(subscriber);
        System.out.println("Subscriber '" + subscriber.getId() + "' unsubscribed from topic: " + topicName);
    }
	public void publish(String topicName, Message message) 
	{
        System.out.println("Publishing message to topic: " + topicName);
        Topic topic = topicRegistry.get(topicName);
        if (topic == null) throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.broadcast(message);
    }
}
