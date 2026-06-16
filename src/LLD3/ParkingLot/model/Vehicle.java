package LLD3.ParkingLot.model;

import LLD3.ParkingLot.model.constant.VehicleType;

public class Vehicle extends BaseModel{
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String colour;

    public Vehicle() {

    }

    public Vehicle(String vehicleNumber, VehicleType vehicleType, String colour) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.colour = colour;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
