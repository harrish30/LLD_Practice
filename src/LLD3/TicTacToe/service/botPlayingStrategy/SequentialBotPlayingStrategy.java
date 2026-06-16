package LLD3.TicTacToe.service.botPlayingStrategy;

import LLD3.TicTacToe.exception.GameOverException;
import LLD3.TicTacToe.model.*;
import LLD3.TicTacToe.model.constant.CellState;

import java.util.List;

public class SequentialBotPlayingStrategy implements BotPlayingStrategy
{
    @Override
    public Move makeMove(Board board, Player bot)
    {
        List<List<Cell>> matrix = board.getMatrix();
        for(int i = 0 ; i < matrix.size() ; i++)
        {
            for(int j = 0 ; j < matrix.size() ; j++)
            {
                Cell cell = matrix.get(i).get(j);
                if(cell.getCellState().equals(CellState.EMPTY))
                {
                    cell.setRow(i);
                    cell.setCol(j);
                    cell.setPlayer(bot);
                    cell.setCellState(CellState.FILLED);
                    return new Move(cell, bot);
                }
            }
        }
        throw new GameOverException("There are no empty cells in the board");
    }
}
