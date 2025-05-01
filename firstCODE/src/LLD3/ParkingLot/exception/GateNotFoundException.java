package LLD3.ParkingLot.exception;

public class GateNotFoundException extends RuntimeException {
    public GateNotFoundException() {
    }

    public GateNotFoundException(String message) {
        super(message);
    }
}
