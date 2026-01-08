package ObserverDesignPattern.Observable;

import ObserverDesignPattern.Observer.CustomerObserver;

public interface ProductObservable 
{
	void registerCustomer(CustomerObserver customer);
	void removeCustomer(CustomerObserver customer);
	void notifyCustomers();
	double getPrice();
	boolean isBackInStock();
	String getName();
}
