package main;

import javax.swing.JPanel;

import entity.Player;

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

    KeyHandler keyHandler = new KeyHandler();
    Player player = new Player(this, keyHandler);
    Thread gameThread;

    GamePanel () {
        this.setPreferredSize(screenDimension);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
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
            //System.out.println("your game is definitely running");

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

                nextDrawTime += drawTime;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;

        player.paintComponent(graphics2D);

        graphics2D.dispose();
    }
    
    public int getFPS() {return this.FPS;}
    public int getTileSize() {return this.tileSize;}
}
