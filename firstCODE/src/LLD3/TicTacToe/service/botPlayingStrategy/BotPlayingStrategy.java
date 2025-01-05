package LLD3.TicTacToe.service.botPlayingStrategy;

import LLD3.TicTacToe.model.Board;
import LLD3.TicTacToe.model.Move;
import LLD3.TicTacToe.model.Player;

public interface BotPlayingStrategy
{
    Move makeMove(Board board, Player player);
}
