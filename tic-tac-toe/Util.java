package tictactoe;

import javax.swing.JOptionPane;

public class Util
{
    public static String fakePlayerName(){
        return "Test";
    }
    public static String promptPlayerName(String prompt){
        String name = "";
        while(name.length() < 1){
            name = JOptionPane.showInputDialog(prompt);
        }
        
        return name;
    }
    
}
