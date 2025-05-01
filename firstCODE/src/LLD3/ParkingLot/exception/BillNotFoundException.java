package LLD3.ParkingLot.exception;

public class BillNotFoundException extends RuntimeException
{
    public BillNotFoundException() {
    }

    public BillNotFoundException(String message) {
        super(message);
    }
}
