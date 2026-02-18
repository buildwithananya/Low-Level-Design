package ParkingLot.strategy.parking;

import java.util.List;
import java.util.Optional;

import ParkingLot.entities.ParkingFloor;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.vehicle.Vehicle;

public class BestFitStrategy implements ParkingStrategy
{
	@Override
	public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors,Vehicle vehicle)
	{
		Optional<ParkingSpot> bestSpot=Optional.empty();
		
		for(ParkingFloor floor:floors)
		{
			Optional<ParkingSpot> spotOnThisFloor=floor.findAvailableSpot(vehicle);
			if(bestSpot.isEmpty())
			{
				// If this is the first spot we've found, it's the best one so far.
                bestSpot = spotOnThisFloor;	
			}
			else
			{
				// A smaller spot size enum ordinal means a tighter fit.
                if (spotOnThisFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal()) 
                {
                    bestSpot = spotOnThisFloor;
                }
			}
		}
		
		return bestSpot;
	}
}
