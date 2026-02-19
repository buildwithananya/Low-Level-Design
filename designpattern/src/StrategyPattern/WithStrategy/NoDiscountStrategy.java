package StrategyPattern.WithStrategy;

import java.util.List;

import StrategyPattern.WithoutStrategy.Customer;
import StrategyPattern.WithoutStrategy.Product;

public class NoDiscountStrategy implements DiscountStrategy 
{
	@Override
	public double applyDiscount(Customer customer, List<Product> products)
	{
		return 0;
	}
}
