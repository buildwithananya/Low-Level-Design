package parkinglot.vehicle;

public class Vehicle 
{
	private String licenseNumber;
	private VehicleSize vehicleSize;
	
	public Vehicle(String licenseNumber,VehicleSize size)
	{
		this.licenseNumber=licenseNumber;
		this.vehicleSize=size;
	}
	
	public String getLicenseNumber()
	{
		return this.licenseNumber;
	}
	
	public VehicleSize getVehicleSize()
	{
		return this.vehicleSize;
	}
}
