package LLD3.TicTacToe.service.botPlayingStrategy;

public class BotPlayingStrategyFactory
{
    public static BotPlayingStrategy getBotPlayingStrategy()
    {
        return new SequentialBotPlayingStrategy();
    }
}
