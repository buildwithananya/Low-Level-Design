package vendingmachine;

import vendingmachine.enums.Coin;

public class VendingMachineDemo 
{
	public static void main(String[] args)
	{
		VendingMachine vendingMachine=VendingMachine.getInstance();
		
		 // Add products to the inventory
        vendingMachine.addItem("A1", "Coke",3,25);
        vendingMachine.addItem("A2", "Pepsi",2,25);
        vendingMachine.addItem("B1", "Water",5,10);
        
        // Select a product
        System.out.println("\n--- Step 1: Select an item ---");
        vendingMachine.selectItem("A1");
        
        // Insert Coins
        vendingMachine.insertCoin(Coin.DIME); // 10
        vendingMachine.insertCoin(Coin.DIME); // 10
        vendingMachine.insertCoin(Coin.NICKEL); // 5
        System.out.println("Current Machine Balance: " + vendingMachine.getBalance());
        
        // Dispense the product
        System.out.println("\n--- Step 3: Dispense item ---");
        vendingMachine.dispense(); // Should dispense Coke
        
        // Select another item
        System.out.println("\n--- Step 4: Select another item ---");
        vendingMachine.selectItem("B1");

        // Insert more amount
        System.out.println("\n--- Step 5: Insert more than needed ---");
        vendingMachine.insertCoin(Coin.QUARTER); // 25

        // Try to dispense the product
        System.out.println("\n--- Step 6: Dispense and return change ---");
        vendingMachine.dispense();
	}
}
