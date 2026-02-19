package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.enums.Coin;

public class HasMoneyState extends VendingMachineState
{
	public HasMoneyState(VendingMachine vendingMachine) 
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
		System.out.println("Already received full amount.");
	}
	
	@Override
	public void refund()
	{
		vendingMachine.refund();
		vendingMachine.resetState();
		vendingMachine.setState(new IdleState(vendingMachine));
	}
	
	@Override
	public void dispense()
	{
		vendingMachine.setState(new DispensingState(vendingMachine));
		vendingMachine.dispenseItem();
	}
}
