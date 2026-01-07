package StrategyPattern.WithStrategy.Ecommerce;

import java.util.List;
import StrategyPattern.WithoutStrategy.Ecommerce.Customer;
import StrategyPattern.WithoutStrategy.Ecommerce.Product;

public interface DiscountStrategy 
{
	double applyDiscount(Customer customer, List<Product> products);
}
