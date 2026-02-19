package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.enums.Coin;

public abstract class VendingMachineState 
{
	VendingMachine vendingMachine;
	
	public VendingMachineState(VendingMachine vendingMachine)
	{
		this.vendingMachine=vendingMachine;
	}
	public abstract void selectItem(String code);
	public abstract void insertCoin(Coin coin);
	public abstract void refund();
	public abstract void dispense();
}
