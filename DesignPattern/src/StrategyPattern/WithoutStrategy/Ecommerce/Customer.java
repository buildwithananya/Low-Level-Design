package StrategyPattern.WithoutStrategy.Ecommerce;

public class Customer 
{
	private String name;
	private CustomerType customerType;
	public Customer(String name, CustomerType customerType)
    {
        this.name = name;
        this.customerType = customerType;
    }

	public CustomerType getCustomerType() 
	{
        return customerType;
    }

    public String getName() 
    {
        return name;
    }
}
