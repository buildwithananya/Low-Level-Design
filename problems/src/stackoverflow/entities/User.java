package stackoverflow.entities;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User 
{
	private final String userID;
	private final String name;
	private final AtomicInteger reputation;
	
	public User(String name)
	{
		this.userID=UUID.randomUUID().toString();
		this.name=name;
		this.reputation=new AtomicInteger(0);
	}
	
	public void updateReputation(int change)
	{
		this.reputation.addAndGet(change);
	}
	public String getUserId() {return this.userID;}
	public String getName(){return this.name;}
	public int getReputation() {return reputation.get();}
}
