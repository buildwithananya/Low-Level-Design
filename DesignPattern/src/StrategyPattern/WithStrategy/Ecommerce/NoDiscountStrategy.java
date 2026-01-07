package StrategyPattern.WithStrategy.Ecommerce;

import java.util.List;
import StrategyPattern.WithoutStrategy.Ecommerce.Customer;
import StrategyPattern.WithoutStrategy.Ecommerce.Product;

public class NoDiscountStrategy implements DiscountStrategy 
{
	@Override
	public double applyDiscount(Customer customer, List<Product> products)
	{
		return 0;
	}
}
