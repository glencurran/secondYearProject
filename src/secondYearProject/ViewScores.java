package secondYearProject;

import javax.swing.*;
import java.io.*;

/**
 * Glen Curran T00018075
 * Second Year Java Project.
 * Concentration Card Game.
 */
public class ViewScores{
    String nextPlayer = null;
    JTextArea output = new JTextArea("High Scores");

    public void open(){
        output.append("\n---------------------");
        try{
            BufferedReader in = new BufferedReader(new FileReader(("players.txt")));
            while((nextPlayer = in.readLine()) != null){
                output.append("\nPlayer Name: " + nextPlayer + "\n");
                //System.out.println("Name: " + nextPlayer); // Testing Output String
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Can't Open File");
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, output);
    }
}
