package LLD3.TicTacToe.service.winningStrategy;
import LLD3.TicTacToe.model.Board;
import LLD3.TicTacToe.model.Cell;
import LLD3.TicTacToe.model.Move;
import LLD3.TicTacToe.model.Player;
import java.util.List;

public class OrderNWinningStrategy implements WinningStrategy
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
        boolean winnerResult = ((checkLeftDiagonal(row, col) && checkWinnerForLeftDiagonal(symbol, matrix))
                || (checkRightDiagonal(row, col, dimension) && checkWinnerForRightDiagonal(symbol, matrix))
                || (checkCorner(row, col, dimension) && checkWinnerForCorner(symbol, matrix))
                || (checkWinnerForRow(symbol, matrix, row))
                || (checkWinnerForCol(symbol, matrix, col)));
        if(winnerResult)
        {
            return lastMove.getPlayer();
        }
        return null;
    }

    private boolean checkWinnerForLeftDiagonal(char symbol, List <List <Cell>> matrix)
    {
        int count = 0;
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

    private boolean checkWinnerForRightDiagonal(char symbol, List <List <Cell>> matrix)
    {
        int count = 0;
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

    private boolean checkWinnerForCorner(char symbol, List <List <Cell>> matrix)
    {
        return ((matrix.get(0).get(0).getPlayer().getSymbol() == symbol) &&
                (matrix.get(0).get(matrix.size() - 1).getPlayer().getSymbol() == symbol) &&
                (matrix.get(matrix.size() - 1).get(0).getPlayer().getSymbol() == symbol) &&
                (matrix.get(matrix.size() - 1).get(matrix.size() - 1).getPlayer().getSymbol() == symbol));
    }

    private boolean checkWinnerForRow(char symbol, List<List<Cell>> matrix, int row)
    {
        int count = 0;
        for(int col = 0 ; col < matrix.size() ; col++)
        {
            if(matrix.get(row).get(col).getPlayer().getSymbol() == symbol)
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

    private boolean checkWinnerForCol(char symbol, List<List<Cell>> matrix, int col)
    {
        int count = 0;
        for(int row = 0 ; row < matrix.size() ; row++)
        {
            if(matrix.get(row).get(col).getPlayer().getSymbol() == symbol)
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

    private boolean checkLeftDiagonal(int row, int col)
    {
        return row == col;
    }

    private boolean checkRightDiagonal(int row, int col, int dimension)
    {
        return ((row + col) == (dimension - 1));
    }

    private boolean checkCorner(int row, int col, int dimension)
    {
        return ((row == 0 && col == 0) ||
                (row == dimension - 1 && col == 0) ||
                (row == 0 && col == dimension - 1) ||
                (row == dimension - 1 && col == dimension - 1));
    }
}
