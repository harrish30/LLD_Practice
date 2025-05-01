package LLD3.ParkingLot.exception;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException() {
    }

    public TicketNotFoundException(String message) {
        super(message);
    }
}
