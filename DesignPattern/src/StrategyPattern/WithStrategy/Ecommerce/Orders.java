package StrategyPattern.WithStrategy.Ecommerce;

import java.util.List;

import StrategyPattern.WithoutStrategy.Ecommerce.Customer;
import StrategyPattern.WithoutStrategy.Ecommerce.Product;

public class Orders 
{
	private List<Product> products;
	private DiscountStrategy discountStrategy;
	public Orders(List<Product> products)
    {
        this.products = products;
    }
	public void setDiscountStrategy(DiscountStrategy discountStrategy)
    {
        this.discountStrategy = discountStrategy;
    }
	public double calculateOrder(Customer customer)
	{
		double discount=0;
		double totalPrice=0;
		for(Product price:products)
		{
			totalPrice+=price.getPrice();
		}
		discount=discountStrategy != null
                ? discountStrategy.applyDiscount(customer, products)
                : 0;
		return totalPrice-discount;
	}
}
