package ObserverDesignPattern.Observable;

import java.util.ArrayList;
import java.util.List;

import ObserverDesignPattern.Observer.CustomerObserver;

public class EcommerceProductObservableImp implements ProductObservable
{
	private String name;
    private double price;
    private boolean inStock;
    private List<CustomerObserver> customers = new ArrayList<>();
    
	public EcommerceProductObservableImp(String name,double price,boolean isInStock)
	{
		this.name=name;
		this.price=price;
		this.inStock=isInStock;
	}
	
	@Override
	public void registerCustomer(CustomerObserver customer)
	{
		customers.add(customer);
	}
	
	@Override
	public void removeCustomer(CustomerObserver customer)
	{
		customers.remove(customer);
	}
	
	@Override
	public void notifyCustomers()
	{
		for(CustomerObserver customer: customers)
			customer.update(this);
	}
	
	// Business logic
    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyCustomers();
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
        notifyCustomers();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isBackInStock() {
        return inStock;
    }

    @Override
    public String getName() {
        return name;
    }
}
