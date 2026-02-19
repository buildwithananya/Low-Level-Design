package parkinglot.strategy.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import parkinglot.entities.ParkingFloor;
import parkinglot.entities.ParkingSpot;
import parkinglot.vehicle.Vehicle;

public class FarthestFirstStrategy implements ParkingStrategy
{
	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors,Vehicle vehicle)
	{
		List<ParkingFloor> reversedFloors = new ArrayList(floors);
		Collections.reverse(reversedFloors );
		for(ParkingFloor floor:reversedFloors)
		{
			Optional<ParkingSpot> availableSpot=floor.findAvailableSpot(vehicle);
			if(availableSpot.isPresent())
				return availableSpot;	
		}
		return Optional.empty();
	}
}
