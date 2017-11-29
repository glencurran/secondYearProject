package secondYearProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GameBoard extends JFrame implements ActionListener{
    JPanel gamePanel = new JPanel();
    JPanel start = new JPanel();
    JButton buttons[];
    JButton beginButton;
    int numButtons;
    ImageIcon turnedOver;
    List<ImageIcon> imageArray = new ArrayList<>();
    List<ImageIcon> imageArray2 = new ArrayList<>();

    ImageIcon images[] = new ImageIcon[8];
    int tempArray[] = new int[8];
    Random randomGenerator = new Random();
    int numClicks = 0;
    int cardHolder1 = 0;
    int cardHolder2 = 0;


    public GameBoard(){
        setTitle("Concentration Card Game");
        setPreferredSize(new Dimension(600, 800));
        setLocation(700, 25);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Trying to set a gap between each card
//        GridBagConstraints gridSpacing = new GridBagConstraints();
//        gridSpacing.weightx = 1;
//        gridSpacing.weighty = .25;
//        gridSpacing.insets = new Insets(5, 1, 5, 1);
//        gridSpacing.gridwidth = GridBagConstraints.REMAINDER;
//        gridSpacing.fill = GridBagConstraints.BOTH;

        images[0] = new ImageIcon(this.getClass().getResource("\\images\\1.png"));
        images[1] = new ImageIcon(this.getClass().getResource("\\images\\1.png"));
        images[2] = new ImageIcon(this.getClass().getResource("\\images\\2.png"));
        images[3] = new ImageIcon(this.getClass().getResource("\\images\\2.png"));
        images[4] = new ImageIcon(this.getClass().getResource("\\images\\3.png"));
        images[5] = new ImageIcon(this.getClass().getResource("\\images\\3.png"));
        images[6] = new ImageIcon(this.getClass().getResource("\\images\\4.png"));
        images[7] = new ImageIcon(this.getClass().getResource("\\images\\4.png"));

        // Building List of secondYearProject.images
        for(int i = 1; i <= 4; i++){
            imageArray.add(new ImageIcon(this.getClass().getResource("\\images\\" + i + ".png")));
        }

        turnedOver = new ImageIcon(this.getClass().getResource("\\images\\cardImage.png"));
        gamePanel.setPreferredSize(new Dimension(500, 450));
        gamePanel.setLayout(new GridLayout(2,imageArray.size()));
        //numButtons = imageArray.size() * 2;
        numButtons = images.length;
        buttons = new JButton[numButtons];

        for(int i = 0; i < images.length; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setIcon(turnedOver);
            gamePanel.add(buttons[i]);
        }


//        for(int i = 0; i <imageArray.size(); i++){
//            for(int j = 0; j < imageArray.size(); j++){
//                imageArray2.add(imageArray.get(i));
//                buttons[j] = new JButton();
//                buttons[j].addActionListener(this);
//                buttons[j].setIcon(turnedOver);
//                gamePanel.add(buttons[j++]);
//                if(i == 0){
//                    imageArray2.add(imageArray.get(i));
//                    buttons[j] = new JButton();
//                    buttons[j].addActionListener(this);
//                    buttons[j].setIcon(turnedOver);
//                    gamePanel.add(buttons[j++]);
//                }else{
//                    imageArray2.add(imageArray.get(i - 1));
//                    buttons[j] = new JButton();
//                    buttons[j].addActionListener(this);
//                    buttons[j].setIcon(turnedOver);
//                    gamePanel.add(buttons[j++]);
//                }
//            }
//        }
//        for(int i = 0, j = 0; i < imageArray.size(); i++){
//            imageArray2.add(imageArray.get(i));
//            buttons[j] = new JButton();
//            buttons[j].addActionListener(this);
//            buttons[j].setIcon(turnedOver);
//            gamePanel.add(buttons[j++]);
//            if(i == 0){
//                imageArray2.add(imageArray.get(i));
//                buttons[j] = new JButton();
//                buttons[j].addActionListener(this);
//                buttons[j].setIcon(turnedOver);
//                gamePanel.add(buttons[j++]);
//            }else{
//                imageArray2.add(imageArray.get(i - 1));
//                buttons[j] = new JButton();
//                buttons[j].addActionListener(this);
//                buttons[j].setIcon(turnedOver);
//                gamePanel.add(buttons[j++]);
//            }
//        }
//
//        //Using java.util.Random to randomize secondYearProject.images
//        Random randomGenerator = new Random();
//        for(int i = 0; i < numButtons; i++){
//            int j = randomGenerator.nextInt(numButtons);
//            imageArray2.add(i, imageArray2.get(j));
//        }

        JLabel nameLabel = new JLabel("Player Name:");
        Font font1 = new Font("SansSerif", Font.BOLD, 25);
        nameLabel.setFont(font1);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(20, 0, 250, 50);

        JLabel nameFromMemory = new JLabel("\"Placeholder\""); // player1.getName();
        font1 = new Font("SansSerif", Font.BOLD, 25);
        nameFromMemory.setFont(font1);
        nameFromMemory.setForeground(Color.RED);
        nameFromMemory.setBounds(270, 0, 250, 50);

        JLabel scoreLabel = new JLabel("Score:");
        font1 = new Font("SansSerif", Font.BOLD, 25);
        scoreLabel.setFont(font1);
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(20, 60, 250, 50);

        JLabel scoreCounterLabel = new JLabel("0");
        font1 = new Font("SansSerif", Font.BOLD, 25);
        scoreCounterLabel.setFont(font1);
        scoreCounterLabel.setForeground(Color.RED);
        scoreCounterLabel.setBounds(270, 60, 250, 50);

        beginButton = new JButton(new ImageIcon(this.getClass().getResource("\\images\\BeginGame.png")));
        beginButton.setBounds(20, 120, 250, 50);

        start.setPreferredSize(new Dimension(200, 200));
        start.setLayout(null);
        start.add(nameLabel);
        start.add(nameFromMemory);
        start.add(scoreLabel);
        start.add(scoreCounterLabel);
        start.add(beginButton);

        // Trying to set a gap between each card
        BorderLayout cardLayout = new BorderLayout(10, 10);
        add(gamePanel, cardLayout.NORTH);
        add(start, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }
//    public void actionPerformed(ActionEvent e){
//        for(int i = 0; i < numButtons; i++){
//            if(e.getSource() == buttons[i]){
//                buttons[i].setIcon(imageArray2.get(i));
//
//            }
//        }
//    }
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < numButtons; i++){
            if(e.getSource() == buttons[i]){
                int j = randomGenerator.nextInt(numButtons);
                buttons[i].setIcon(images[j]);
                cardHolder1 = i;
                numClicks++;
             if(numClicks == 3){
                 buttons[cardHolder1].setIcon(turnedOver);
                 numClicks = 0;
             }
            }
        }
    }

}
