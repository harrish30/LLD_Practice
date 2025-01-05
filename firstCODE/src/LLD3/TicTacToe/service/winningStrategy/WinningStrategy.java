package LLD3.TicTacToe.service.winningStrategy;

import LLD3.TicTacToe.model.Board;
import LLD3.TicTacToe.model.Move;
import LLD3.TicTacToe.model.Player;

public interface WinningStrategy
{
    Player checkWinner(Board board, Move lastMove);
}
