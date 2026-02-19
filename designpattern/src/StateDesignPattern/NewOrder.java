package StateDesignPattern;

public class NewOrder implements OrderState
{
	@Override
	public void ship(OrderContext order)
	{
		System.out.println("Order has been shipped");
		order.setState(new ShippedOrder());
	}
	@Override
	public void deliver(OrderContext order)
	{
		System.out.println("Order cannot be delivered as it has not been shipped yet");
	}
	@Override
	public void cancel(OrderContext order)
	{
		System.out.println("Order has been cancelled");
		order.setState(new CancelledOrder());
	}
}
