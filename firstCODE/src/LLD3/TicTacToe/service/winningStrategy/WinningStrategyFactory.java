package LLD3.TicTacToe.service.winningStrategy;

public class WinningStrategyFactory
{
    public static WinningStrategy getWinningStrategy(WinningStrategyName name, int dimension)
    {
        return switch (name)
        {
            case ORDERONEWINNINGSTRATEGY -> new OrderOneWinningStrategy(dimension);
            case ORDERNWINNINGSTRATEGY -> new OrderNWinningStrategy();
            case ORDERNSQWINNINGSTRATEGY -> new OrderNSqWinningStrategy();
        };
    }
}
