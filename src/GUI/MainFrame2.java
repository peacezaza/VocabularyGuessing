package GUI;

import javax.swing.*;

public class MainFrame2 {
    private JFrame frame = new JFrame();


    public MainFrame2(){
        createJFrame();
    }

    public void createJFrame(){
        frame.setSize(800, 500);
        frame.setTitle("Vocabulary guessing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public void playPage(){

    }

    public static void main(String[] args) {
        new MainFrame2();
    }
}

