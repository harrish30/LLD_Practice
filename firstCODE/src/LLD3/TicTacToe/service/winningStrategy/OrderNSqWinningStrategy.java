package LLD3.TicTacToe.service.winningStrategy;

import LLD3.TicTacToe.model.Board;
import LLD3.TicTacToe.model.Cell;
import LLD3.TicTacToe.model.Move;
import LLD3.TicTacToe.model.Player;

import java.util.List;

public class OrderNSqWinningStrategy implements WinningStrategy
{
    @Override
    public Player checkWinner(Board board, Move lastMove)
    {
        char symbol = lastMove.getPlayer().getSymbol();
        Cell cell = lastMove.getCell();
        int row = cell.getRow();
        int col = cell.getCol();
        int dimension = board.getDimension();
        List<List<Cell>> matrix = board.getMatrix();
        boolean winnerResult = checkWinnerForLeftDiagonal(matrix)
                || checkWinnerForRightDiagonal(matrix)
                || checkWinnerForCorner(matrix)
                || checkWinnerForRow(matrix)
                || checkWinnerForCol(matrix);
        if(winnerResult)
        {
            return lastMove.getPlayer();
        }
        return null;
    }

    private boolean checkWinnerForLeftDiagonal(List <List <Cell>> matrix)
    {
        int count = 0;
        char symbol = matrix.get(0).get(0).getPlayer().getSymbol();
        for(int i = 0 ; i < matrix.size() ; i++)
        {
            if(matrix.get(i).get(i).getPlayer().getSymbol() == symbol)
            {
                count++;
            }
        }
        if(count == matrix.size())
        {
            return true;
        }
        return false;
    }

    private boolean checkWinnerForRightDiagonal(List <List <Cell>> matrix)
    {
        int count = 0;
        char symbol = matrix.get(0).get(matrix.size() - 1).getPlayer().getSymbol();
        for(int i = 0, j = matrix.size() - 1 ; i < matrix.size() && j >= 0 ; i++,j--)
        {
            if(matrix.get(i).get(j).getPlayer().getSymbol() == symbol)
            {
                count++;
            }
        }
        if(count == matrix.size())
        {
            return true;
        }
        return false;
    }

    private boolean checkWinnerForCorner(List <List <Cell>> matrix)
    {
        char symbol = matrix.get(0).get(0).getPlayer().getSymbol();
        return ((matrix.get(0).get(matrix.size() - 1).getPlayer().getSymbol() == symbol) &&
                (matrix.get(matrix.size() - 1).get(0).getPlayer().getSymbol() == symbol) &&
                (matrix.get(matrix.size() - 1).get(matrix.size() - 1).getPlayer().getSymbol() == symbol));
    }

    private boolean checkWinnerForRow(List <List <Cell>> matrix)
    {
        int dimension = matrix.size();
        for(int i = 0 ; i < dimension - 1 ; i++)
        {
            char firstColSymbol = matrix.get(i).get(0).getPlayer().getSymbol();
            int count = 0;
            for(int j = 0 ; j < dimension - 1 ; j++)
            {
                if(matrix.get(i).get(j).getPlayer().getSymbol() == firstColSymbol)
                {
                    count++;
                }
            }
            if(count == dimension)
            {
                return true;
            }
        }
        return false;
    }
    private boolean checkWinnerForCol(List<List<Cell>> matrix)
    {
        int dimension = matrix.size();
        for(int i = 0 ; i < dimension - 1 ; i++)
        {
            char firstColSymbol = matrix.get(0).get(i).getPlayer().getSymbol();
            int count = 0;
            for(int j = 0 ; j < dimension - 1 ; j++)
            {
                if(matrix.get(j).get(i).getPlayer().getSymbol() == firstColSymbol)
                {
                    count++;
                }
            }
            if(count == dimension)
            {
                return true;
            }
        }
        return false;
    }
}
