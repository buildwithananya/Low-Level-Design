package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.ProductObservable;

public class EcommerceCustomerObserverImp implements CustomerObserver
{
	private String customerName;
    private double interestedPrice;

    public EcommerceCustomerObserverImp(String customerName, double interestedPrice) 
    {
        this.customerName = customerName;
        this.interestedPrice = interestedPrice;
    }
    
	@Override
	public void update(ProductObservable product)
	{
		if(product.isBackInStock())
			System.out.println(customerName +" has been notified that the "+ product.getName() + 
					" is back in stock");
		
		if(product.getPrice()<=interestedPrice)
			System.out.println(customerName +" has been notified that the price of "+ product.getName() + 
                    " has been dropped");
	}
}
