package LLD3.ParkingLot.exception;

public class InvalidInputException extends RuntimeException
{
    public InvalidInputException() {
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
