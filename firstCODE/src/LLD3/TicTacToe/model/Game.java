package LLD3.TicTacToe.model;

import LLD3.TicTacToe.Exception.InvalidBotCountException;
import LLD3.TicTacToe.Exception.InvalidDimensionException;
import LLD3.TicTacToe.Exception.InvalidPlayerSizeException;
import LLD3.TicTacToe.Exception.InvalidSymbolSetupException;
import LLD3.TicTacToe.service.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game
{
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List <Move> moves;
    private List <Board> boardStates;
    private WinningStrategy winningStrategy;
    private int noOfSymbols;


    private Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy)
    {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.noOfSymbols = players.size();
    }

    public static Builder builder()
    {
        return new Builder();
    }
    //getters
    public Board getCurrentBoard()
    {
        return currentBoard;
    }

    public List<Player> getPlayers()
    {
        return players;
    }

    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    public GameStatus getGameStatus()
    {
        return gameStatus;
    }

    public List<Move> getMoves()
    {
        return moves;
    }

    public List<Board> getBoardStates()
    {
        return boardStates;
    }

    public WinningStrategy getWinningStrategy()
    {
        return winningStrategy;
    }

    public int getNoOfSymbols()
    {
        return noOfSymbols;
    }

    //setters
    public void setCurrentBoard(Board currentBoard)
    {
        this.currentBoard = currentBoard;
    }

    public void setPlayers(List<Player> players)
    {
        this.players = players;
    }

    public void setCurrentPlayer(Player currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }

    public void setGameStatus(GameStatus gameStatus)
    {
        this.gameStatus = gameStatus;
    }

    public void setMoves(List<Move> moves)
    {
        this.moves = moves;
    }

    public void setBoardStates(List<Board> boardStates)
    {
        this.boardStates = boardStates;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy)
    {
        this.winningStrategy = winningStrategy;
    }

    public void setNoOfSymbols(int noOfSymbols)
    {
        this.noOfSymbols = noOfSymbols;
    }
    public static class Builder
    {
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;
        private int dimension;

        public Builder setCurrentBoard(Board currentBoard)
        {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players)
        {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy)
        {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setDimensions(int dimension)
        {
            this.dimension = dimension;
            return this;
        }

        private void validateNoOfPlayers()
        {
            if(players.size() >= dimension || players.size() < dimension - 2)
            {
                throw new InvalidPlayerSizeException("Player size should be N - 1 or N - 2");
            }
        }
        private void validatePlayerSymbols()
        {
            HashSet <Character> symbols = new HashSet<>();
            //TODO : convert the below code in this method into lambda expression using streams
            players.forEach(player -> symbols.add(player.getSymbol()));
            if(symbols.size() != players.size())
            {
                throw new InvalidSymbolSetupException("There should be unique symbols for all players");
            }
        }
        private void validateBotCount()
        {
            int botCount = 0;
            //TODO : convert the below code in this method into lambda expression using streams
            for(Player player: players)
            {
                if(player.getPlayerType().equals(PlayerType.BOT))
                {
                    botCount++;
                }
            }
            if(botCount > 1 || botCount < 0)
            {
                throw new InvalidBotCountException("Bot count should be 0 or 1");
            }
        }
        //TODO: add a validation for dimension, it should be from 3 to 10.
        private void validateDimension()
        {
            if(currentBoard.getDimension() < 3 || currentBoard.getDimension() > 10)
            {
                throw new InvalidDimensionException("Enter a dimension between 3 and 10");
            }
        }
        private void validate()
        {
            validateBotCount();
            validateNoOfPlayers();
            validatePlayerSymbols();
        }
        public Game build()
        {
            validate();
            return new Game(new Board(dimension), players, winningStrategy);
        }
    }
}
