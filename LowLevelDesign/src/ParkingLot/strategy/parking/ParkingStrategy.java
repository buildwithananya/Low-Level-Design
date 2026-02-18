package ParkingLot.strategy.parking;

import java.util.List;
import java.util.Optional;

import ParkingLot.entities.ParkingFloor;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.vehicle.Vehicle;

public interface ParkingStrategy 
{
	Optional<ParkingSpot> findSpot(List<ParkingFloor> floors,Vehicle vehicle);
}
