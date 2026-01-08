package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.ProductObservable;

public interface CustomerObserver 
{
	void update(ProductObservable product);
}
