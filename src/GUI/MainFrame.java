package GUI;

import Program.Guess;
import Program.Level;
import Program.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    private JFrame frame = new JFrame();
    private JPanel panelForFirstPage = new JPanel();
    private JPanel panelForPlayPage =new JPanel();
    JPanel panelForBar = new JPanel();
    private Guess guess = new Guess();
    private ButtonStyles buttonStyles = new ButtonStyles(guess);
    private Level level = new Level();
    private int number;
    private JButton choice1 = new JButton();
    private JButton choice2 = new JButton();
    private JButton choice3 = new JButton();
    private JButton choice4 = new JButton();
    private Word rightWord, wrongWord1, wrongWord2, wrongWord3;
    private JProgressBar progressBar;
    JLabel labelForRightWord = new JLabel();


    public MainFrame(){
        setPlayPage();
        setFirstPage();
        createJFrame();
    }

    public void createJFrame(){
        frame.setSize(700, 450);
        frame.setTitle("Vocabulary guessing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,40));
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public void setFirstPage() {
        panelForPlayPage.setVisible(false);
        JPanel panelForText = new JPanel();
        JPanel panelForButton = new JPanel();
        // Create panel with BorderLayout layout

        JLabel welcomeText = new JLabel("WELCOME TO VOCABULARY GAME");
        JLabel levelText =new JLabel("Your level is " + level.getLevel());
//        Create label

        welcomeText.setFont(new Font("Arial", Font.PLAIN, 30));
        levelText.setFont(new Font("Arial", Font.PLAIN, 25));
//        Set font

        panelForText.add(welcomeText);
        panelForText.add(levelText);
        panelForButton.add(buttonStyles.getStartButton(panelForPlayPage, panelForFirstPage));
        panelForButton.add(buttonStyles.getExitButton());
        // Add components to panel using BorderLayout constraints

        panelForFirstPage.setLayout(new BoxLayout(panelForFirstPage, BoxLayout.Y_AXIS));
        panelForText.setLayout(new BoxLayout(panelForText, BoxLayout.Y_AXIS));
//        Set layout

        panelForText.setOpaque(false);
        panelForButton.setOpaque(false);
        // Set the background color of all components to transparent


        panelForFirstPage.add(panelForText);
        panelForFirstPage.add(Box.createRigidArea(new Dimension(0,80)));
        panelForFirstPage.add(panelForButton);
//        Add panel to the panel which hold everything in this page

        panelForFirstPage.setBackground(Color.DARK_GRAY);
        welcomeText.setForeground(Color.WHITE);
        levelText.setForeground(Color.WHITE);
//        Set color

        frame.add(panelForFirstPage);
    }

    public void setPlayPage(){
        JPanel panelForRightWord = new JPanel();
        JPanel panelForButton = new JPanel();
//        Crete panel



        changeWord();
//        create button for choice
        final String[] message = {rightWord.getThai()};
        JTextArea textArea = new JTextArea(message[0]);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));


        progressBar = new JProgressBar();
        progressBar.setMaximum(level.getGapLevel());
        progressBar.setStringPainted(true);
        panelForBar.add(progressBar);


        choice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(guess.getUsingWord(0).getEng().equals(rightWord.getEng())){
                    level.addExperience();
                    JOptionPane.showMessageDialog(frame,"Correct","",JOptionPane.INFORMATION_MESSAGE);
                    progressBar.setValue(level.getExperience());
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Wrong!!", "", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(frame,textArea,"",JOptionPane.INFORMATION_MESSAGE);
                }
                guess.clearWords();
                changeWord();
                progressBar.setMaximum(level.getGapLevel());
                message[0] = rightWord.getThai();
                textArea.setText(message[0]);

                if(level.getLevel()>5 && level.getLevel()<15){
                    guess.getData(1);
                }
                else if (level.getLevel() < 15) {
                    guess.getData(2);
                }
            }
        });
        choice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(guess.getUsingWord(1).getEng().equals(rightWord.getEng())){
                    level.addExperience();
                    JOptionPane.showMessageDialog(frame,"Correct","",JOptionPane.INFORMATION_MESSAGE);
                    progressBar.setValue(level.getExperience());
                }
                else {
                    JOptionPane.showMessageDialog(frame,"Wrong","",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(frame,textArea,"",JOptionPane.INFORMATION_MESSAGE);
                }
                guess.clearWords();
                changeWord();
                progressBar.setMaximum(level.getGapLevel());
                message[0] = rightWord.getThai();
                textArea.setText(message[0]);
                if(level.getLevel()>5 && level.getLevel()<15){
                    guess.getData(1);
                } else if (level.getLevel() < 15) {
                    guess.getData(2);
                }
            }
        });
        choice3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(guess.getUsingWord(2).getEng().equals(rightWord.getEng())){
                    level.addExperience();
                    JOptionPane.showMessageDialog(frame,"Correct","",JOptionPane.INFORMATION_MESSAGE);
                    progressBar.setValue(level.getExperience());
                }
                else {
                    JOptionPane.showMessageDialog(frame,"Wrong","",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(frame,textArea,"",JOptionPane.INFORMATION_MESSAGE);
                }
                guess.clearWords();
                changeWord();
                progressBar.setMaximum(level.getGapLevel());
                message[0] = rightWord.getThai();
                textArea.setText(message[0]);
                if(level.getLevel()>5 && level.getLevel()<15){
                    guess.getData(1);
                }
                else if (level.getLevel() < 15) {
                    guess.getData(2);
                }
            }
        });
        choice4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(guess.getUsingWord(3).getEng().equals(rightWord.getEng())){
                    level.addExperience();
                    JOptionPane.showMessageDialog(frame,"Correct","",JOptionPane.INFORMATION_MESSAGE);
                    progressBar.setValue(level.getExperience());
                }
                else {
                    JOptionPane.showMessageDialog(frame,"Wrong!!","",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(frame,textArea,"",JOptionPane.INFORMATION_MESSAGE);

                }
                guess.clearWords();
                changeWord();
                progressBar.setMaximum(level.getGapLevel());
                message[0] = rightWord.getThai();
                textArea.setText(message[0]);
                if(level.getLevel()>5 && level.getLevel()<15){
                    guess.getData(1);
                }
                else if (level.getLevel() < 15) {
                    guess.getData(2);
                }
            }
        });


        panelForButton.add(choice1);
//        panelForButton.add(Box.createRigidArea(new Dimension(0,30)));
        panelForButton.add(choice2);
//        panelForButton.add(Box.createRigidArea(new Dimension(0,30)));
        panelForButton.add(choice3);
//        panelForButton.add(Box.createRigidArea(new Dimension(0,30)));
        panelForButton.add(choice4);
//        panelForButton.add(Box.createRigidArea(new Dimension(0,30)));

        choice1.setPreferredSize(new Dimension(200,80));




        panelForButton.setLayout(new GridLayout(2,2));
        panelForPlayPage.setLayout(new BoxLayout(panelForPlayPage, BoxLayout.Y_AXIS));
//        panelForButton.setLayout(new BoxLayout(panelForButton, BoxLayout.Y_AXIS));

        panelForButton.setOpaque(false);
        panelForRightWord.setOpaque(false);

        panelForRightWord.add(labelForRightWord);
        panelForPlayPage.add(panelForRightWord);
        panelForPlayPage.add(Box.createRigidArea(new Dimension(0,50)));
        panelForPlayPage.add(panelForButton);
        panelForPlayPage.add(panelForBar);

        panelForPlayPage.setBackground(Color.DARK_GRAY);
        labelForRightWord.setForeground(Color.WHITE);

        frame.add(panelForPlayPage);
    }

    public void changeWord(){
        rightWord = guess.rightWord();
        wrongWord1 = guess.wrongWord();
        wrongWord2 = guess.wrongWord();
        wrongWord3 = guess.wrongWord();
        guess.shuffleWords();
        labelForRightWord.setText(rightWord.getEng());
        choice1.setText(guess.getUsingWord(0).getThai());
        choice1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        choice2.setText(guess.getUsingWord(1).getThai());
        choice2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        choice3.setText(guess.getUsingWord(2).getThai());
        choice3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        choice4.setText(guess.getUsingWord(3).getThai());
        choice4.setFont(new Font("Tahoma", Font.PLAIN, 16));
    }



}

class Main{
    public static void main(String[] args) {
        new MainFrame();
    }
}
