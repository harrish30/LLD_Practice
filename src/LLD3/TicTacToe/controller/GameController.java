package LLD3.TicTacToe.controller;
import LLD3.TicTacToe.model.*;
import LLD3.TicTacToe.model.constant.GameStatus;
import LLD3.TicTacToe.service.winningStrategy.WinningStrategyFactory;
import LLD3.TicTacToe.service.winningStrategy.WinningStrategyName;

import java.util.List;

public class GameController
{
    public Game createGame(int dimension, List <Player> players, WinningStrategyName winningStrategyName)
    {
        return Game.builder()
                .setDimensions(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinningStrategy(winningStrategyName, dimension))
                .build();
    }
    public void displayBoard(Game game)
    {
        game.getCurrentBoard().displayBoard();
    }
    public GameStatus getGameStatus(Game game)
    {
        return game.getGameStatus();
    }
    public Move executeMove(Game game, Player player)
    {
//        game.getBoardStates().add(game.getBoardStates().getLast());
//        //adding previously played matrix to current aka copying
//        return player.makeMove(game.getBoardStates().getLast());
        return player.makeMove(game.getCurrentBoard());
    }
    public Player checkWinner(Game game, Move lastMovePlayed, int [] draw)
    {
        return game.getWinningStrategy().checkWinner(game.getCurrentBoard(), lastMovePlayed, draw);
    }
    public Board undoMove(Game game, Move lastMovePlayed)
    {
        //TODO
//        game.getCurrentBoard()
        return null;
    }
    public void replayGame(Game game)
    {
        //TODO
    }
}
