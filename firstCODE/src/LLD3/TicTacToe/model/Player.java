package LLD3.TicTacToe.model;

import java.util.Scanner;

public class Player
{
    private char symbol;
    private PlayerType playerType;
    private int id;
    private String name;

    public Player()
    {

    }

    public Player(char symbol, PlayerType playerType, int id, String name)
    {
        this.symbol = symbol;
        this.playerType = playerType;
        this.id = id;
        this.name = name;
    }

    //getter
    public PlayerType getPlayerType()
    {
        return playerType;
    }
    public char getSymbol()
    {
        return symbol;
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }

    //setter
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }
    public void setPlayerType(PlayerType playerType)
    {
        this.playerType = playerType;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public Move makeMove(Board board)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the row for the target cell");
        int row = scn.nextInt();
        System.out.println("Enter the col for the target cell");
        int col = scn.nextInt();
        //TODO : validate the row & col entered by the player. Ex :- inbound check, filled or not
        if (row >= 0 && row < board.getDimension() && col >= 0 && col < board.getDimension())
        {
            Cell playedMoveCell = board.getMatrix().get(row).get(col);
            if(playedMoveCell.getCellState().equals(CellState.EMPTY))
            {
                playedMoveCell.setRow(row);
                playedMoveCell.setCol(col);
                playedMoveCell.setCellState(CellState.FILLED);
                playedMoveCell.setPlayer(this);
                return new Move(playedMoveCell, this);
            }
            else
            {
                System.out.println("The cell is already filled. Enter different row and col number");
                return makeMove(board);
            }
        }
        return null;
    }
}
