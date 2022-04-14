package tictactoe;

public class Player
{

    // class field 
    private String playerName = "";
    private char playerMarker; // X of O
    private int playerScore = 0; // board total while playing each game
    private int playerTotal = 0; //overall wins by player 

    // receives player name as attribute
    public Player(String name)
    {
        this.playerName = name;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public char getPlayerMarker()
    {
        return playerMarker;
    }

    public void setPlayerMarker(char playerMarker)
    {
        this.playerMarker = playerMarker;
    }

    public int getPlayerScore()
    {
        return playerScore;
    }

    // add 1 by 1 to player score
    public void addPlayerScore()
    {
        this.playerScore++;
    }

    public int getPlayerTotal()
    {
        return playerTotal;
    }

    public void addPlayerTotal(int playertotal)
    {
        this.playerTotal = this.playerTotal + playertotal;
    }

    public void resetPlayerTotal()
    {
        this.playerTotal = 0;
    }

} // class
