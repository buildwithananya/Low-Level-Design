package StrategyPattern.WithStrategy.Ecommerce;

import java.util.List;
import StrategyPattern.WithoutStrategy.Ecommerce.Customer;
import StrategyPattern.WithoutStrategy.Ecommerce.Product;

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
