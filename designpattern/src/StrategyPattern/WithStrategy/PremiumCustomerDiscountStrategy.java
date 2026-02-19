package StrategyPattern.WithStrategy;

import java.util.List;

import StrategyPattern.WithoutStrategy.Customer;
import StrategyPattern.WithoutStrategy.Product;

public class PremiumCustomerDiscountStrategy implements DiscountStrategy 
{
	@Override
	public double applyDiscount(Customer customer, List<Product> products)
	{
		double totalPrice=0;
		for(Product price:products)
		{
			totalPrice+=price.getPrice();
		}
		return totalPrice*0.30;
	}
}
