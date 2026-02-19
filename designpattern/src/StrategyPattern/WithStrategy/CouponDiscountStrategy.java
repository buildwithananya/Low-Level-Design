package StrategyPattern.WithStrategy;

import java.util.List;

import StrategyPattern.WithoutStrategy.Customer;
import StrategyPattern.WithoutStrategy.Product;

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
