package ChainOfResponsibilityDesignPattern;

public abstract class DiscountHandler 
{
	protected DiscountHandler next;
	public void setNext(DiscountHandler next)
	{
		this.next=next;
	}
	public abstract void handleDiscount(double discount);
}
