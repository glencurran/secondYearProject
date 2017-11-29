package secondYearProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * GameBoard class constructs the game using JPanel and filling it with buttons. The buttons are in a grid format.
 * when the game launches they all are placed face down with only the back of the card visible. A shuffle card method
 * runs and using a prebuilt array or deck of images it shuffles their positions in the array.
 */
public class GameBoard extends JFrame implements ActionListener{
    JPanel gamePanel = new JPanel();
    JPanel start = new JPanel();
    JButton buttons[];
    JButton restart;
    static int numButtons;
    ImageIcon turnedOver;
    ImageIcon images[] = new ImageIcon[8];
    int numClicks = 0;
    int cardHolder1 = 0;
    int cardHolder2 = 0;
    JLabel scoreCounterLabel;
    int score = 0;
    Player player1;


    public GameBoard(){
        setTitle("Concentration Card Game");
        setPreferredSize(new Dimension(600, 800));
        setLocation(700, 25);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /**
         * Building an array of images, Using each 1 twice so they can match.
         * Cheated and hard coded the values, I was originally using a for loop to generate this but I was
         * running into alot of problems and needed to simplify my code.
         */
        images[0] = new ImageIcon(this.getClass().getResource("\\images\\1.png"));
        images[1] = new ImageIcon(this.getClass().getResource("\\images\\1.png"));
        images[2] = new ImageIcon(this.getClass().getResource("\\images\\2.png"));
        images[3] = new ImageIcon(this.getClass().getResource("\\images\\2.png"));
        images[4] = new ImageIcon(this.getClass().getResource("\\images\\3.png"));
        images[5] = new ImageIcon(this.getClass().getResource("\\images\\3.png"));
        images[6] = new ImageIcon(this.getClass().getResource("\\images\\4.png"));
        images[7] = new ImageIcon(this.getClass().getResource("\\images\\4.png"));

        turnedOver = new ImageIcon(this.getClass().getResource("\\images\\cardImage.png"));
        gamePanel.setPreferredSize(new Dimension(500, 450));
        gamePanel.setLayout(new GridLayout(2, images.length));
        numButtons = images.length;
        buttons = new JButton[numButtons];

        /**
         * loop used to populate the game board with cards/buttons.
         */
        for(int i = 0; i < images.length; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setIcon(turnedOver);
            gamePanel.add(buttons[i]);
        }
        /**
         * adding various jComponents to the lower JPanel.
         */
        JLabel nameLabel = new JLabel("Player Name:");
        Font font1 = new Font("SansSerif", Font.BOLD, 25);
        nameLabel.setFont(font1);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(20, 0, 250, 50);

        JLabel nameFromMemory = new JLabel("\"Placeholder for player name\""); // player1.getName();
        font1 = new Font("SansSerif", Font.BOLD, 25);
        nameFromMemory.setFont(font1);
        nameFromMemory.setForeground(Color.RED);
        nameFromMemory.setBounds(270, 0, 250, 50);

        JLabel scoreLabel = new JLabel();
        scoreLabel.setText("Score:");
        font1 = new Font("SansSerif", Font.BOLD, 25);
        scoreLabel.setFont(font1);
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(20, 60, 250, 50);

        scoreCounterLabel = new JLabel("" + score);
        font1 = new Font("SansSerif", Font.BOLD, 25);
        scoreCounterLabel.setFont(font1);
        scoreCounterLabel.setForeground(Color.RED);
        scoreCounterLabel.setBounds(270, 60, 250, 50);

        restart = new JButton(new ImageIcon(this.getClass().getResource("\\images\\Restart.png")));
        restart.addActionListener(this);
        restart.setBounds(20, 120, 250, 50);

        start.setPreferredSize(new Dimension(200, 200));
        start.setLayout(null);
        start.add(nameLabel);
//        start.add(nameFromMemory);
        start.add(scoreLabel);
        start.add(scoreCounterLabel);
        start.add(restart);

        /**
         * shuffleCards() called statically to rearrange the deck.
         */
        shuffleCards(images);

        // Trying to set a gap between each card
        BorderLayout cardLayout = new BorderLayout(10, 10);
        add(gamePanel, cardLayout.NORTH);
        add(start, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }
    /**
     * Shuffle method uses java.util.Random to generate a random number between 0 and 8(numButtons).
     * It takes an array of ImageIcons and rearranges them.
     *
     */
    public  static void shuffleCards(ImageIcon[] images){
        Random randomNumber = new Random();
        for(int i = 0 ; i < numButtons; i++){
            int rand = randomNumber.nextInt(numButtons);
            ImageIcon tempHolder = images[i];
            images[i] = images[rand];
            images[rand] = tempHolder;
        }
    }

    /**
     * checkMatch() takes in two JButtons are arguments and then checks to see if their references match. If they do
     * it returns true and if they don't it returns false.
     */
    public static boolean checkMatch(JButton button1, JButton button2){
        if(button1.getIcon().equals( button2.getIcon())){
            return true;
        }
        return false;
    }

    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < numButtons; i++){
            if(e.getSource() == buttons[i]){
                numClicks++;
                if(numClicks == 1){
                    buttons[i].setIcon(images[i]);
                    cardHolder1 = i;
                }else if(numClicks == 2){
                    buttons[i].setIcon(images[i]);
                    cardHolder2 = i;
                }
                if(numClicks == 3){
                    if(checkMatch(buttons[cardHolder1], buttons[cardHolder2])){
                        score++;
                        scoreCounterLabel.setText("" + score);
                        numClicks = 0;
                    }else{
                        buttons[cardHolder1].setIcon(turnedOver);
                        buttons[cardHolder2].setIcon(turnedOver);
                        numClicks = 0;
                    }
                }

                if(Integer.parseInt(scoreCounterLabel.getText()) == 4){
                    JOptionPane.showMessageDialog(null, "You won");
                }
            }else if(e.getSource() == restart){
                super.dispose();
                GameBoard gameBoard1 = new GameBoard();
                gameBoard1.setVisible(true);
            }
        }
    }

}
