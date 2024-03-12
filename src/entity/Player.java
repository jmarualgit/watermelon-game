package entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player (GamePanel gp, KeyHandler kh) {
        this.gamePanel = gp;
        this.keyHandler = kh;

        setStartingValues();
        getImage();
    }

    private void getImage() {
        try {
            this.playerIcon = ImageIO.read(getClass().getResourceAsStream("/textures/map-textures/watermelon-char-right.png"));
        } catch (IOException e) {e.printStackTrace();}
    }

    private void setStartingValues() {
        setXPos(100);
        setYPos(100);
        setSpeed(gamePanel.getFPS() / 48);
    }

    public void update() {
        if (keyHandler.getUpPressed()) {
            //System.out.println("up pressed");
            setYPos(getYPos() - getSpeed());
        }

        if (keyHandler.getDownPressed()) {
            setYPos(getYPos() + getSpeed());
        }

        if (keyHandler.getRightPressed()) {
            setXPos(getXPos() + getSpeed());
        }

        if (keyHandler.getLeftPressed()) {
            setXPos(getXPos() - getSpeed());
        }
    }

    public void paintComponent(Graphics2D graphics2d) {
        graphics2d.drawImage(this.playerIcon, getXPos(), getYPos(), gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
}
