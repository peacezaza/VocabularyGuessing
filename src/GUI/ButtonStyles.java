package GUI;

import Program.Guess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStyles {
    private JButton startButton = new JButton();
    private JButton exitButton = new JButton();
    private JButton checkButton = new JButton();
    private JButton firstChoice = new JButton();
    private Guess guess = new Guess();

    public ButtonStyles(Guess guess){
        this.guess = guess;
    }

    public JButton getStartButton(JPanel showPanel, JPanel hidePanel1){
        startButton.setText("START");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hidePanel1.setVisible(false);
                showPanel.setVisible(true);
            }
        });
        return startButton;
    }

    public JButton getExitButton(){
        this.exitButton.setText("EXIT");
        this.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return this.exitButton;
    }





}
