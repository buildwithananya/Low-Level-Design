package StrategyPattern.WithStrategy;

import java.util.List;

import StrategyPattern.WithoutStrategy.Customer;
import StrategyPattern.WithoutStrategy.Product;

public interface DiscountStrategy 
{
	double applyDiscount(Customer customer, List<Product> products);
}
