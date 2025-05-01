package LLD3.ParkingLot.exception;

public class InvalidRequestException extends RuntimeException
{
  public InvalidRequestException()
  {

  }

  public InvalidRequestException(String message)
    {
        super(message);
    }
}
