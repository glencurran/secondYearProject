package secondYearProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JFrame implements ActionListener{
    JButton newGame;
    JButton viewHighScores;

    public TitleScreen(){
        setTitle("Concentration Card Game");
        setSize(500, 400);
        setLocation(700, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.lightGray);
        contentPane.setLayout(null);

        ImageIcon homeImage = new ImageIcon(this.getClass().getResource("\\images\\MainMenuTitle.png"));
        JLabel imageHolder = new JLabel(homeImage);
        imageHolder.setBounds(30, 20, homeImage.getIconWidth() ,homeImage.getIconHeight());


        newGame = new JButton(new ImageIcon(this.getClass().getResource("\\images\\NewGameButton.png")));
        newGame.setBounds(30, 250, 200, 75);
        newGame.addActionListener(this);
        viewHighScores = new JButton(new ImageIcon(this.getClass().getResource("\\images\\HighScoresButton.png")));
        viewHighScores.setBounds(270, 250, 200, 75);
        viewHighScores.addActionListener(this);

        contentPane.add(imageHolder);
        contentPane.add(newGame);
        contentPane.add(viewHighScores);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == newGame){
            AddPlayer player1 = new AddPlayer();
            player1.setVisible(true);
            super.dispose();// Close secondYearProject.TitleScreen window
        }else if(e.getSource() == viewHighScores){
            ViewScores view = new ViewScores();
            view.open();
        }
    }
}
