package vendingmachine.entities;

import java.util.HashMap;
import java.util.Map;

public class Inventory 
{
	private final Map<String,Item> itemMap=new HashMap<>();
	private final Map<String, Integer> stockMap = new HashMap<>();
	
	public void addItem(String code,Item item,Integer quantity)
	{
		itemMap.put(code, item);
		stockMap.put(code, quantity);
	}
	public void reduceStock(String code)
	{
		stockMap.put(code, stockMap.get(code)-1);
	}
	public boolean isAvailable(String code)
	{
		return stockMap.getOrDefault(code, 0) > 0;
	}
	public Item getItem(String code) 
	{
        return itemMap.get(code);
    }
}
