package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.enums.Coin;

public class ItemSelectedState extends VendingMachineState
{
	public ItemSelectedState(VendingMachine vendingMachine)
	{
		super(vendingMachine);
	}
	
	@Override
	public void selectItem(String code)
	{
		System.out.println("Item already selected.");
	}
	
	@Override
	public void insertCoin(Coin coin)
	{
		vendingMachine.addBalance(coin.getValue());
        System.out.println("Coin Inserted: " + coin.getValue());
        int price = vendingMachine.getSelectedItem().getPrice();
        if (vendingMachine.getBalance() >= price) {
            System.out.println("Sufficient money received.");
            vendingMachine.setState(new HasMoneyState(vendingMachine));
        }
	}
	
	@Override
	public void refund()
	{
		int amount = vendingMachine.getBalance();
	    System.out.println("Refunding: " + amount);
	    vendingMachine.resetState();
	    vendingMachine.setState(new IdleState(vendingMachine));
	}
	
	@Override
	public void dispense()
	{
		System.out.println("Please insert sufficient money.");
	}
}
