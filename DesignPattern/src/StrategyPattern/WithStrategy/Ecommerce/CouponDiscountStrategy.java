package StrategyPattern.WithStrategy.Ecommerce;

import java.util.List;

import StrategyPattern.WithoutStrategy.Ecommerce.Customer;
import StrategyPattern.WithoutStrategy.Ecommerce.Product;

public class CouponDiscountStrategy implements DiscountStrategy 
{
	private final String couponCode;

    public CouponDiscountStrategy(String couponCode) 
    {
        this.couponCode = couponCode;
    }
	@Override
	public double applyDiscount(Customer customer, List<Product> products)
	{
		if ("SAVE10".equalsIgnoreCase(couponCode)) {
            return 100; // flat ₹100 off
        }
        return 0;
	}
}
