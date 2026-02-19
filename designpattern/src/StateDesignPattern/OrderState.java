package StateDesignPattern;

public interface OrderState 
{
	void ship(OrderContext order);
	void deliver(OrderContext order);
	void cancel(OrderContext order);
}
