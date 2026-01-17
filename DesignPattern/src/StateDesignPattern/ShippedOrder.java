package StateDesignPattern;

public class ShippedOrder implements OrderState
{
	@Override
	public void ship(OrderContext order)
	{
		System.out.println("Order has already been shipped");
	}
	@Override
	public void deliver(OrderContext order)
	{
		System.out.println("Order delivered");
		order.setState(new DeliveredOrder());
	}
	@Override
	public void cancel(OrderContext order)
	{
		System.out.println("Order cannot be cancelled as its already shipped");
	}
}
