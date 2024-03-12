package main;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
    
    MyFrame () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        this.setBackground(Color.black);
        this.pack();

        this.setLocationRelativeTo(null);   // set screen starting position to center
        this.setResizable(false);
        this.setVisible(true);

        gamePanel.startGame();
    }
}
