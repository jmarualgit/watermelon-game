package main;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {

    // 16 x 16 art
    private int originalTileSize = 16;
    private int scale = 4;

    private int tileSize = originalTileSize * scale;
    
    // 4 x 3 resolution
    private int maxColumns = 16;
    private int maxRows = 12;

    private int screenWidth = tileSize * maxColumns;
    private int screenHeight = tileSize * maxRows;

    private Dimension screenDimension = new Dimension(screenWidth, screenHeight);

    private int FPS = 144;

    Thread gameThread;

    GamePanel () {
        this.setPreferredSize(screenDimension);
        //
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawTime = 1000000000 / FPS;
        double nextDrawTime = drawTime + System.nanoTime();

        // implement sleep method
        while (gameThread != null) {
            System.out.println("your game is definitely running");
            

            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                // for if updating and repainting take too long
                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;

        graphics2D.setColor(Color.white);
        graphics2D.fillRect(100, 100, 100, 100);
    }
    
    public int getFPS() {return this.FPS;}
}
