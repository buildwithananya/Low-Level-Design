package StateDesignPattern;

public class OrderContext 
{
	private OrderState state;
	public OrderContext()
	{
		this.state=new NewOrder(); //default state
	}
	public void setState(OrderState state)
	{
		this.state = state;
	}
	public void ship()
	{
		state.ship(this);
	}
	public void deliver()
	{
		state.deliver(this);
	}
	public void cancel()
	{
		state.cancel(this);
	}
}
