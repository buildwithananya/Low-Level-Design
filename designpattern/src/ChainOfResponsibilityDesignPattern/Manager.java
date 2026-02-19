package ChainOfResponsibilityDesignPattern;

public class Manager extends DiscountHandler 
{
	@Override
	public void handleDiscount(double discount)
	{
		if(discount<=10)
			System.out.println("Discount approved by Manager");
		else if(next!=null)
			next.handleDiscount(discount);
	}
}
