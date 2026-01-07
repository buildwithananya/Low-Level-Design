package StrategyPattern.WithoutStrategy.Ecommerce;

import java.util.List;

public class Order 
{
	private List<Product> products;
	private boolean isFestivalSale;
	private String couponCode;
	public Order(List<Product> products,boolean isFestivalSale,String couponCode)
	{
	   this.products = products;
	   this.isFestivalSale = isFestivalSale;
	   this.couponCode = couponCode;
	}
	// Multiple conditional rules - Breaks Open/Closed Principle
	public double calculateOrder(Customer customer)
	{
		double discount=0;
		double totalPrice=0;
		for(Product price:products)
		{
			totalPrice+=price.getPrice();
		}
		if(customer.getCustomerType()==CustomerType.PREMIUM)
		{
			discount=totalPrice*0.30;
		}
		else if(isFestivalSale)
		{
			discount=totalPrice*0.20;
		}
		else if("SAVE100".equalsIgnoreCase(couponCode))
		{
			discount=100;
		}
		return totalPrice-discount;
	}
}
