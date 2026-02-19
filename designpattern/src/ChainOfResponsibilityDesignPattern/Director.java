package ChainOfResponsibilityDesignPattern;

public class Director extends DiscountHandler 
{
	@Override
	public void handleDiscount(double discount)
	{
		if(discount<=20)
			System.out.println("Discount approved by Director");
		else 
			System.out.println("Discount too high, cannot be approved!");
	}
}
