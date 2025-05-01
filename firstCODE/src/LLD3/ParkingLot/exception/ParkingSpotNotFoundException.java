package LLD3.ParkingLot.exception;

public class ParkingSpotNotFoundException extends RuntimeException {
  public ParkingSpotNotFoundException() {
  }

  public ParkingSpotNotFoundException(String message) {
        super(message);
    }
}
