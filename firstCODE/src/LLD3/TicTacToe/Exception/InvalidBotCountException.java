package LLD3.TicTacToe.Exception;

public class InvalidBotCountException extends RuntimeException
{
    public InvalidBotCountException() {
    }

    public InvalidBotCountException(String message) {
        super(message);
    }

    public InvalidBotCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBotCountException(Throwable cause) {
        super(cause);
    }

    public InvalidBotCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
