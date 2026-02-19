package StateDesignPattern;

public class DeliveredOrder implements OrderState
{
	@Override
	public void ship(OrderContext order)
	{
		System.out.println("Cannot ship. Order already delivered!");
	}
	@Override
	public void deliver(OrderContext order)
	{
		System.out.println("Order has already been delivered");
	}
	@Override
	public void cancel(OrderContext order)
	{
		System.out.println("Order cannot be cancelled as its already delivered");
	}
}
