package ParkingLot;

import java.util.Optional;

import ParkingLot.entities.ParkingFloor;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.entities.ParkingTicket;
import ParkingLot.vehicle.Bike;
import ParkingLot.vehicle.Car;
import ParkingLot.vehicle.Truck;
import ParkingLot.vehicle.Vehicle;
import ParkingLot.vehicle.VehicleSize;

public class ParkingLotDemo 
{
	public static void main(String[] args)
	{
		ParkingLotSystem parkinglot=ParkingLotSystem.getInstance();
		
		//	1. Initialize a new Parking Lot and create floors and spots
		ParkingFloor floor1=new ParkingFloor(1);
		floor1.addSpot(new ParkingSpot("F1-S1",VehicleSize.SMALL));
		floor1.addSpot(new ParkingSpot("F1-M1",VehicleSize.MEDIUM));
		floor1.addSpot(new ParkingSpot("F1-L1",VehicleSize.LARGE));
		
		ParkingFloor floor2=new ParkingFloor(1);
		floor2.addSpot(new ParkingSpot("F2-S1",VehicleSize.SMALL));
		floor2.addSpot(new ParkingSpot("F2-M1",VehicleSize.MEDIUM));
		floor2.addSpot(new ParkingSpot("F2-L1",VehicleSize.LARGE));
		
		parkinglot.addFloors(floor1);
		parkinglot.addFloors(floor2);
		
		// 2. Add Vehicles
		floor1.displayAvailability();
		floor2.displayAvailability();
		
		//	Factory Design Pattern
		Vehicle bike=new Bike("V1-B111");
		Vehicle car=new Car("V2-C111");
		Vehicle truck=new Truck("V3-T111");
		
		Optional<ParkingTicket> bikeParking=parkinglot.parkVehicle(bike);
		Optional<ParkingTicket> car1Parking=parkinglot.parkVehicle(car);
		Optional<ParkingTicket> truckParking=parkinglot.parkVehicle(truck);
		
		System.out.println("\n--- Availability after parking ---");
        floor1.displayAvailability();
        floor2.displayAvailability();

        // 3. Simulate another car entry (should go to floor 2)
        Vehicle car2=new Car("V4-C222");
        Optional<ParkingTicket> car2Parking=parkinglot.parkVehicle(car2);
        
        // 4. Simulate a vehicle entry that fails (no available spots)
        Vehicle bike2 = new Bike("V5-B222");
        Optional<ParkingTicket> failedBikeTicketOpt = parkinglot.parkVehicle(bike2);
        
        if(car1Parking.isPresent())
        {
        	Optional<Double> feeOpt =parkinglot.unparkVehicle(car2.getLicenseNumber());
        	feeOpt.ifPresent(fee -> System.out.printf("Car C-456 unparked. Fee: $%.2f\n", fee));
        }
        System.out.println("\n--- Availability after one car leaves ---");
        floor1.displayAvailability();
        floor2.displayAvailability();
	}
}
