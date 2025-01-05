package LLD3.TicTacToe.model;

import LLD3.TicTacToe.service.botPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player
{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(char symbol, int id, BotDifficultyLevel botDifficultyLevel)
    {
        super(symbol, PlayerType.BOT, id, "Chitti");
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board)
    {
        return BotPlayingStrategyFactory.getBotPlayingStrategy().makeMove(board, this);
    }
}
