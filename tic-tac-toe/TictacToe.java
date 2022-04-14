package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// extend and become a GUI window and listener 
public class TictacToe extends JFrame implements ActionListener
{
    // fields 

    private static boolean xTurn = true;

    private static Player player1; // declare player 1 
    private static Player player2; // declare player 2
    private static Player cat;

    private JLabel player1score; // declare in ram
    private JLabel player2score;
    private JLabel catScore;

    // holds all 9 buttons of the gameboard 
    private static JButton[] button = new JButton[9];

    private static int[] winsArray =
    {
        7, 56, 448, 73, 146, 292, 273, 84
    };

    public TictacToe()
    {

        player1 = new Player(Util.promptPlayerName("Enter Player One Name"));
        player2 = new Player(Util.promptPlayerName("Enter Player Two Name"));
        cat = new Player("cat");

        player1.setPlayerMarker('X'); //starting marker
        player2.setPlayerMarker('O');

        System.out.println(player1.getPlayerName() + " is " + player1.getPlayerMarker());
        System.out.println(player2.getPlayerName() + " is " + player2.getPlayerMarker());

        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(6, 3, 2, 2));
        gameBoard.setBackground(Color.decode("#D4F1F4"));

        int myBinary = 1; // number to go on each button attribute

        for (int index = 0; index < 9; index++)
        {

            //create button and add to array
            button[index] = new JButton();
            // add listener to button 
            button[index].addActionListener(this);
            //  set nutton attribute to bitwise int 
            button[index].setActionCommand("" + myBinary);
            //test myBinary dis paly button
            // add button to panel 
            gameBoard.add(button[index]);
            // get ready for the next button 
            myBinary = myBinary * 2;

        }

        // ScoreBoard Labels 
        gameBoard.add(new JLabel("Player 1"));
        gameBoard.add(new JLabel(player1.getPlayerName()));
        player1score = new JLabel(); // instanciate 
        gameBoard.add(player1score); // add to panel

        gameBoard.add(new JLabel("Player 2"));
        gameBoard.add(new JLabel(player2.getPlayerName()));
        player2score = new JLabel(); // instanciate 
        gameBoard.add(player2score); // add to panel

        gameBoard.add(new JLabel("Tied Game"));
        gameBoard.add(new JLabel("Cat"));
        catScore = new JLabel("");
        gameBoard.add(catScore);

        //main to show window
        this.setLocationRelativeTo(null);
        this.add(gameBoard);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    } //constructor 

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ///System.out.println(xTurn);

        // create object name for Action Event
        JButton pressedButton = (JButton) e.getSource();
        // if (preddedButton.getText())

        // ignore clicks if button already played
        if (pressedButton.getText() == "")
        {

            if (xTurn) // X just clicked    
            {
                pressedButton.setText("X");
                //player 1 is X
                if (player1.getPlayerMarker() == 'X')
                {
                    player1.addPlayerTotal(Integer.parseInt(e.getActionCommand()));
                    System.out.println(player1.getPlayerTotal());
                } else //player 2 is X
                {
                    player2.addPlayerTotal(Integer.parseInt(e.getActionCommand()));
                    System.out.println(player2.getPlayerTotal());
                }
                xTurn = false;
            } else // O turn 
            {
                pressedButton.setText("O");
                if (player1.getPlayerMarker() == 'O')
                {
                    player1.addPlayerTotal(Integer.parseInt(e.getActionCommand()));
                    System.out.println(player1.getPlayerTotal());
                } else //player 2 is O
                {
                    player2.addPlayerTotal(Integer.parseInt(e.getActionCommand()));
                    System.out.println(player2.getPlayerTotal());
                }

                xTurn = true;

            } // if X or O

            if (check4winner(player1.getPlayerTotal()))
            {
                System.out.println("P1 won");
                player1.addPlayerScore();
                player1score.setText(" " + player1.getPlayerScore());
                resetGame();

            } else
            {
                if (player1.getPlayerTotal() + player2.getPlayerTotal() == 511)
                {
                    System.out.println("Cat Won");
                    cat.addPlayerScore();
                    catScore.setText("" + cat.getPlayerScore());
                    resetGame();
                }
            }
            if (check4winner(player2.getPlayerTotal()))
            {
                System.out.println("P2 won");
                player2.addPlayerScore();
                player2score.setText(" " + player2.getPlayerScore());
                resetGame();
            } // ignore if 
            else
            {
                if (player1.getPlayerTotal() + player2.getPlayerTotal() == 511)
                {
                    System.out.println("Cat Won");
                    cat.addPlayerScore();
                    catScore.setText("" + cat.getPlayerScore());
                    resetGame();
                }
            }
        }// action

    }

    public static void resetGame()
    {
        for (int index = 0; index < button.length; index++)
        {
            button[index].setText("");
        }
        player1.resetPlayerTotal();
        player2.resetPlayerTotal();

    }

    public static boolean check4winner(int total)
    {
        for (int index = 0; index < winsArray.length; index++)
        {
            // compare the winsArray occurance bitwise to the current total 
            if ((winsArray[index] & total) == winsArray[index])
            {
                return true;
            }
        }
        return false;
    } // check4winner

    public static void main(String[] args)
    { // start
        TictacToe window = new TictacToe();
        window.setVisible(true);
    } // stop

}
