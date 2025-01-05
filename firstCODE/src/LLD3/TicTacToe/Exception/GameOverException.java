package LLD3.TicTacToe.Exception;

public class GameOverException extends RuntimeException
{
    public GameOverException()
    {
        super();
    }

    public GameOverException(String message)
    {
        super(message);
    }

    public GameOverException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public GameOverException(Throwable cause)
    {
        super(cause);
    }

    protected GameOverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
