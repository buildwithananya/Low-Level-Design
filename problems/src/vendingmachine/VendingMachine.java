package vendingmachine;

import vendingmachine.entities.Inventory;
import vendingmachine.entities.Item;
import vendingmachine.enums.Coin;
import vendingmachine.state.IdleState;
import vendingmachine.state.VendingMachineState;

public class VendingMachine 
{
	private static VendingMachine vendingMachineInstance;
	private Inventory inventory = new Inventory();
	private VendingMachineState currentVendingMachineState;
	private int balance = 0;
	private String selectedItemCode;
	
	public VendingMachine() 
	{
        currentVendingMachineState = new IdleState(this);
    }

    public static synchronized VendingMachine getInstance() 
    {
        if(vendingMachineInstance==null)
        	vendingMachineInstance = new VendingMachine();
        return vendingMachineInstance;
    }
    
    public Inventory getInventory() 
    { 
    	return inventory; 
    }
    
    public int getBalance() 
    { 
    	return balance;  	
    }
    
    public void selectItem(String code)
    {
    	currentVendingMachineState.selectItem(code);
    }
    
    public void insertCoin(Coin coin)
    {
    	currentVendingMachineState.insertCoin(coin);
    }
    
    public void dispense() 
    {
        currentVendingMachineState.dispense();
    }
    
    public void refund()
	{
    	System.out.println("Refunding: " + balance);
        balance = 0;
	} 
    
    public Item addItem(String code,String name,int quantity,int price)
    {
    	Item item=new Item(code,name,price);
    	inventory.addItem(code, item, quantity);
    	return item;
    }
    
    public void addBalance(int value)
    {
    	balance+=value;
    }
    
    public void dispenseItem()
    {
    	Item item=inventory.getItem(selectedItemCode);
    	if(balance>=item.getPrice())
    	{
    		inventory.reduceStock(selectedItemCode);
    		balance-=item.getPrice();
    		System.out.println("Dispensed: " + item.getName());
    		if(balance>0)
    		{
    			System.out.println("Returning change: " + balance);
    		}
    	}
    	resetState();
    	setState(new IdleState(this));
    }
    
    public void resetState()
    {
    	selectedItemCode=null;
    	balance=0;
    }
    
    public Item getSelectedItem() 
    {
        return inventory.getItem(selectedItemCode);
    }
    
    public void setSelectedItemCode(String code) 
    {
        this.selectedItemCode = code;
    }

    public void setState(VendingMachineState vendingMachineState) 
    {
        this.currentVendingMachineState = vendingMachineState;
    }
}
