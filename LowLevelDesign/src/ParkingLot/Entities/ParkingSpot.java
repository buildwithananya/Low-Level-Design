package ParkingLot.Entities;

import ParkingLot.vehicle.Vehicle;
import ParkingLot.vehicle.VehicleSize;

public class ParkingSpot 
{
	private String spotId;
	private boolean isOccupied;
	private VehicleSize spotSize;
	private Vehicle parkedVehicle; 
	
	public ParkingSpot(String spotId,VehicleSize spotSize) 
	{
		this.spotId=spotId;
		this.spotSize=spotSize;
		this.parkedVehicle=null;
		this.isOccupied=false;
	}
	
	public String getSpotId()
	{
		return this.spotId;
	}
	
	public VehicleSize getSpotSize()
	{
		return this.spotSize;
	}
	
	public synchronized boolean isAvailable() 
	{
        return !isOccupied;
    }

    public boolean isOccupied() 
    {
        return isOccupied;
    }
    
    public synchronized void parkVehicle(Vehicle vehicle) 
    {
    	this.parkedVehicle=vehicle;
    	this.isOccupied=true;
    }
    
    public synchronized void unparkVehicle() 
    {
    	this.parkedVehicle=null;
    	this.isOccupied=false;
    }
	
	public boolean canFitVehicle(Vehicle vehicle)
	{
		if(isOccupied) return false;
		
		switch(vehicle.getVehicleSize())
		{
			case SMALL:
				return spotSize==VehicleSize.SMALL;
			case MEDIUM:
				return spotSize==VehicleSize.MEDIUM;
			case LARGE:
				return spotSize==VehicleSize.LARGE;
			default:
				return false;
		}
	}
}
