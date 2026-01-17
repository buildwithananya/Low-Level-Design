package ChainOfResponsibilityDesignPattern;

public class SalesExecutive extends DiscountHandler 
{
	@Override
	public void handleDiscount(double discount)
	{
		if(discount<=5)
			System.out.println("Discount approved by Sales Executive");
		else if(next!=null)
			next.handleDiscount(discount);
	}
}
