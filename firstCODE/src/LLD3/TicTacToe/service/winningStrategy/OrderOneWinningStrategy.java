package LLD3.TicTacToe.service.winningStrategy;

import LLD3.TicTacToe.model.Board;
import LLD3.TicTacToe.model.Cell;
import LLD3.TicTacToe.model.Move;
import LLD3.TicTacToe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy
{
    private int dimension;
    private List <HashMap<Character, Integer>> rowHashMapList;// index in the list will correspond to the row number for hashmap identification
    private List <HashMap<Character, Integer>> colHashMapList;// index in the list will correspond to the col number for hashmap identification
    private HashMap <Character, Integer> leftDiagonal;
    private HashMap <Character, Integer> rightDiagonal;
    private HashMap<Character, Integer> cornerHashMap;

    public OrderOneWinningStrategy(int dimension)
    {
        this.dimension = dimension;
        this.rowHashMapList = new ArrayList<>();
        this.colHashMapList = new ArrayList<>();
        this.leftDiagonal = new HashMap<>();
        this.rightDiagonal = new HashMap<>();
        this.cornerHashMap = new HashMap<>();
        for(int i = 0 ; i < dimension ; i++)
        {
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove)
    {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        boolean winnerResult = ((checkCorner(row, col) && winnerCheckForCorners(board.getMatrix(), symbol))
        || (checkLeftDiagonal(row, col) && checkAndUpdateForLeftDiagonalHashMap(symbol))
        || (checkRightDiagonal(row, col) && checkAndUpdateForRightDiagonalHashMap(symbol))
        || (checkAndUpdateForRowHashMap(row, symbol))
        || (checkAndUpdateForColHashMap(col, symbol)));

        if(winnerResult)
        {
            return player;
        }
        else
        {
            return null;
        }
    }
    private boolean checkCorner(int row, int col)
    {
        return ((row == 0 && col == 0)
                || (row == 0 && col == dimension - 1)
                || (row == dimension - 1 && col == 0)
                || (row == dimension - 1 && col == dimension - 1));
    }

    private boolean checkLeftDiagonal(int row, int col)
    {
        return row == col;
    }

    private boolean checkRightDiagonal(int row, int col)
    {
        return ((row + col) == (dimension - 1));
    }
    //TODO: there are multiple duplicate lines of code, try to remove them.

    //TODO: shorten this code using inbuilt hashmap methods
    private boolean checkAndUpdateForRowHashMap(int row, char symbol)
    {
        HashMap <Character, Integer> rowHashMap = rowHashMapList.get(row);
        if(rowHashMap.containsKey(symbol))
        {
            rowHashMap.put(symbol, rowHashMap.get(symbol) + 1);
            return rowHashMap.get(symbol) == dimension;
        }
        else
        {
            rowHashMap.put(symbol, 1);
        }
        return false;
    }
    //TODO: shorten this code using inbuilt hashmap methods
    private boolean checkAndUpdateForColHashMap(int col, char symbol)
    {
        HashMap <Character, Integer> colHashMap = colHashMapList.get(col);
        if(colHashMap.containsKey(symbol))
        {
            colHashMap.put(symbol, colHashMap.get(symbol) + 1);
            return colHashMap.get(symbol) == dimension;
        }
        else
        {
            colHashMap.put(symbol, 1);
        }
        return false;
    }
    //TODO: shorten this code using inbuilt hashmap methods
    private boolean checkAndUpdateForLeftDiagonalHashMap(char symbol)
    {
        if (leftDiagonal.containsKey(symbol))
        {
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);
            return leftDiagonal.get(symbol) == dimension;
        }
        else
        {
            leftDiagonal.put(symbol, 1);
        }
        return false;
    }
    //TODO: shorten this code using inbuilt hashmap methods
    private boolean checkAndUpdateForRightDiagonalHashMap(char symbol)
    {
        if (rightDiagonal.containsKey(symbol))
        {
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);
            return rightDiagonal.get(symbol) == dimension;
        }
        else
        {
            rightDiagonal.put(symbol, 1);
        }
        return false;
    }
    private boolean winnerCheckForCorners(List<List<Cell>> matrix, char symbol)
    {
        if(cornerHashMap.containsKey(symbol))
        {
            cornerHashMap.put(symbol, cornerHashMap.get(symbol)+1);
            return cornerHashMap.get(symbol) == 4;
        }
        else
        {
            cornerHashMap.put(symbol, 1);
        }
        return false;
    }
}
