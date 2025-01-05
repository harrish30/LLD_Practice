package LLD3.TicTacToe.Exception;

public class InvalidDimensionException extends RuntimeException
{
    public InvalidDimensionException() {
        super();
    }

    public InvalidDimensionException(String message) {
        super(message);
    }

    public InvalidDimensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDimensionException(Throwable cause) {
        super(cause);
    }

    protected InvalidDimensionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
