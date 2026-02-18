package ParkingLot.strategy.fee;

import ParkingLot.Entities.ParkingTicket;

public interface FeeStrategy 
{
	double calculateFee(ParkingTicket parkingTicket);
}
