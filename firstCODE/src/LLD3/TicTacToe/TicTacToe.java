package LLD3.TicTacToe;

import LLD3.TicTacToe.controller.GameController;
import LLD3.TicTacToe.model.*;
import LLD3.TicTacToe.service.winningStrategy.WinningStrategyName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe
{
    public static void main(String[] args)
    {
        GameController gameController = new GameController();
        int id = 1;
        List <Player> players = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");
        System.out.println("Enter the dimension of the board: ");
        int dimension = scn.nextInt();
        System.out.println("Do you want a bot in your game? Y or N");
        String botAns = scn.next();
        if(botAns.equalsIgnoreCase("Y")) //ignore the case for the input
        {
            Player bot = new Bot('$', id++, BotDifficultyLevel.HARD);
            players.add(bot);
        }
        while(id < dimension)
        {
            System.out.println("Enter player name: ");
            String playerName = scn.next();
            System.out.println("Enter player symbol: ");
            char symbol = scn.next().charAt(0);
            Player newPlayer = new Player(symbol, PlayerType.HUMAN, id++, playerName);
            players.add(newPlayer);
        }
        Collections.shuffle(players); //randomise the list of players
        Game game = gameController.createGame(dimension, players, WinningStrategyName.ORDERONEWINNINGSTRATEGY);
        int playerIndex = -1;
        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS))
        {
            System.out.println("Current board status: ");
            //TODO : add the undo logic, don't ask for undo when board is empty, and don't ask for undo when bot is the player who played the last move.
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex = playerIndex % players.size();
            Move movePlayed = gameController.executeMove(game, players.get(playerIndex));
            game.getMoves().add(movePlayed); // add moves
            game.getBoardStates().add(game.getCurrentBoard()); // add board states
            Player winner = gameController.checkWinner(game, movePlayed);
            if(winner != null)
            {
                System.out.println("The winner is: " + winner.getName());
                break;
            }
            if(game.getMoves().size() == game.getCurrentBoard().getDimension() * game.getCurrentBoard().getDimension())
            {
                System.out.println("GAME IS DRAW");
                break;
            }
        }
        System.out.println("Final board status");
        gameController.displayBoard(game);
        System.out.println("Do you want to replay? Y or N");
        //TODO: make the loop run again
        //do while i guess
        //TODO: draw condition before the board is filled
    }
}