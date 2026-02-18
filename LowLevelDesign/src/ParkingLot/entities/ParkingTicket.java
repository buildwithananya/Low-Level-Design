package ParkingLot.entities;

import java.util.Date;
import java.util.UUID;

import ParkingLot.vehicle.Vehicle;

public class ParkingTicket 
{
	private String ticketId;
	private Vehicle vehicle;
	private ParkingSpot spot;
	private long entryTimestamp;
	private long exitTimestamp;
	
	public ParkingTicket(Vehicle vehicle,ParkingSpot spot)
	{
		this.ticketId=UUID.randomUUID().toString();
		this.vehicle=vehicle;
		this.spot=spot;
		this.entryTimestamp=new Date().getTime();
	}
	
	public String getTicketId() {return this.ticketId;}
	public Vehicle getVehicle() {return this.vehicle;}
	public ParkingSpot getParkingSpot() {return this.spot;}
	public long getEntryTimestamp() { return entryTimestamp; }
    public long getExitTimestamp() { return exitTimestamp; }
    
    public void setExitTimestamp()
    {
    	this.exitTimestamp=new Date().getTime();
    }
}
