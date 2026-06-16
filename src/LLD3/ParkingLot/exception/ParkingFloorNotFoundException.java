package LLD3.ParkingLot.exception;

public class ParkingFloorNotFoundException extends RuntimeException{
    public ParkingFloorNotFoundException() {
    }

    public ParkingFloorNotFoundException(String message) {
        super(message);
    }
}
