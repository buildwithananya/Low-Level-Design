package StateDesignPattern;

public class CancelledOrder implements OrderState
{
	@Override
	public void ship(OrderContext order)
	{
		System.out.println("Cannot ship. Order already cancelled!");
	}
	@Override
	public void deliver(OrderContext order)
	{
		System.out.println("Cannot deliver as the order has already been cancelled");
	}
	@Override
	public void cancel(OrderContext order)
	{
		System.out.println("Order already cancelled");
	}
}
