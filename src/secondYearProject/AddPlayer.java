package secondYearProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Glen Curran T00018075
 * Second Year Java Project.
 * Concentration Card Game.
 */
public class AddPlayer extends JFrame implements ActionListener {

    JButton addPlayer, startGame, goBack;
    JTextField nameField;
    Player player1 = new Player();

    public AddPlayer(){
        setTitle("Add Player");
        setSize(600, 550);
        setLocation(700, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.lightGray);
        contentPane.setLayout(null);

        ImageIcon homeImage = new ImageIcon(this.getClass().getResource("\\images\\AddPlayerImage.png"));
        JLabel imageHolder = new JLabel(homeImage);
        imageHolder.setBounds(50, 20, homeImage.getIconWidth() ,homeImage.getIconHeight());


        JLabel nameLabel = new JLabel("Player Name:");
        Font font1 = new Font("SansSerif", Font.BOLD, 25);
        nameLabel.setFont(font1);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(50, 230, 250, 50);

        nameField = new JTextField();
        nameField.setFont(font1);
        nameField.setBounds(300, 230, 250, 50);

        JLabel addPlayerLabel = new JLabel("Confirm Add Player");
        addPlayerLabel.setFont(font1);
        addPlayerLabel.setForeground(Color.black);
        addPlayerLabel.setBounds(50, 300, 250, 50);

        addPlayer = new JButton(new ImageIcon(this.getClass().getResource("\\images\\ConfirmSave.png")));
        addPlayer.setBounds(300, 300, 250, 50);
        addPlayer.addActionListener(this);

        JLabel mainMenuLabel = new JLabel("Back To Main Menu");
        mainMenuLabel.setFont(font1);
        mainMenuLabel.setForeground(Color.black);
        mainMenuLabel.setBounds(50, 370, 250, 50);

        goBack = new JButton(new ImageIcon(this.getClass().getResource("\\images\\MainMenu.png")));
        goBack.setBounds(300, 370, 250, 50);
        goBack.addActionListener(this);

        JLabel startGameLabel = new JLabel("Start Game");
        startGameLabel.setFont(font1);
        startGameLabel.setForeground(Color.black);
        startGameLabel.setBounds(50, 440, 250, 50);

        startGame = new JButton(new ImageIcon(this.getClass().getResource("\\images\\BeginGame.png")));
        startGame.setBounds(300, 440, 250, 50);
        startGame.addActionListener(this);

        contentPane.add(imageHolder);
        contentPane.add(nameLabel);
        contentPane.add(nameField);
        contentPane.add(addPlayerLabel);
        contentPane.add(addPlayer);
        contentPane.add(mainMenuLabel);
        contentPane.add(goBack);
        contentPane.add(startGameLabel);
        contentPane.add(startGame);
    }
    public void saveName(String name) throws IOException{
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("players.txt", true));
            writer.write("\n" + name + "\n");
            writer.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "File not created");
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addPlayer){
            try {
                player1.setName(nameField.getText());
                saveName(player1.getName());
                JOptionPane.showMessageDialog(null, "Name Saved Successfully");
            }catch (IOException f){
                JOptionPane.showMessageDialog(null, "Name Saved Unsuccessfully");
                f.printStackTrace();
            }
        }else if(e.getSource() == goBack){
            super.dispose();// Close addPlayer window
            TitleScreen game1 =  new TitleScreen();
            game1.setVisible(true);
        }else if(e.getSource() == startGame){
            super.dispose();
            GameBoard gameBoard1 = new GameBoard();
            gameBoard1.setVisible(true);
        }
    }
}
