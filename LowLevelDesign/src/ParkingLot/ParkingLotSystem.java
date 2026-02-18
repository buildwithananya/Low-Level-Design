package ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import ParkingLot.Entities.ParkingFloor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Entities.ParkingTicket;
import ParkingLot.strategy.fee.FeeStrategy;
import ParkingLot.strategy.fee.FlatRateFeeStrategy;
import ParkingLot.strategy.parking.BestFitStrategy;
import ParkingLot.strategy.parking.ParkingStrategy;
import ParkingLot.vehicle.Vehicle;

public class ParkingLotSystem 
{
	private static ParkingLotSystem instance;
	private ParkingStrategy parkingStrategy;
	private FeeStrategy feeStrategy;
	private final List<ParkingFloor> floors = new ArrayList<>();
	private final Map<String, ParkingTicket> activeTickets;
	
	//Strategy Design Pattern
	private ParkingLotSystem()
	{
		this.feeStrategy = new FlatRateFeeStrategy();
        this.parkingStrategy = new BestFitStrategy();
        this.activeTickets = new ConcurrentHashMap<>();
	}
	//Singleton Pattern
	public static synchronized ParkingLotSystem getInstance() 
	{
        if (instance == null) 
        {
            instance = new ParkingLotSystem();
        }
        return instance;
    }
	public void setFeeStrategy (FeeStrategy feeStrategy) 
	{
        this.feeStrategy = feeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) 
    {
        this.parkingStrategy = parkingStrategy;
    }
    
    public void addFloors(ParkingFloor floor)
    {
    	floors.add(floor);
    }
    
    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle)
    {
    	Optional<ParkingSpot> availableSpot=parkingStrategy.findSpot(floors, vehicle);
    	if(availableSpot.isPresent())
    	{
    		ParkingSpot spot=availableSpot.get();
    		spot.parkVehicle(vehicle);
    		ParkingTicket ticket=new ParkingTicket(vehicle,spot);
    		activeTickets.put(vehicle.getLicenseNumber(), ticket);
    		System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getLicenseNumber(), spot.getSpotId(), ticket.getTicketId());
    		return Optional.of(ticket); 
    	}
    	System.out.println("No available spot for " + vehicle.getLicenseNumber());
        return Optional.empty();
    }
    
    public Optional<Double> unparkVehicle(String licenseNumber)
    {
    	ParkingTicket ticket= activeTickets.remove(licenseNumber);
    	if (ticket == null) 
    	{
            System.out.println("Ticket not found");
            return Optional.empty();
        }
    	ticket.setExitTimestamp();
    	ticket.getParkingSpot().unparkVehicle();
    	Double parkingFee=feeStrategy.calculateFee(ticket);
    	return Optional.of(parkingFee);
    }
}
