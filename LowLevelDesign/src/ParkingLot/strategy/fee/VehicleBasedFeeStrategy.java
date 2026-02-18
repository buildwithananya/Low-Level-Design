package ParkingLot.strategy.fee;

import java.util.Map;

import ParkingLot.entities.ParkingTicket;
import ParkingLot.vehicle.VehicleSize;

public class VehicleBasedFeeStrategy implements FeeStrategy
{
	private static final Map<VehicleSize, Double> vehicleWiseHourlyRates = Map.of(
		    VehicleSize.SMALL, 10.0,
		    VehicleSize.MEDIUM, 12.0,
		    VehicleSize.LARGE, 15.0
		);
	@Override
	public double calculateFee(ParkingTicket parkingTicket)
	{
		long duration= parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
		long hours = (duration / (1000 * 60 * 60)) + 1;
	    return hours * vehicleWiseHourlyRates.get(parkingTicket.getVehicle().getVehicleSize());
	}
}
