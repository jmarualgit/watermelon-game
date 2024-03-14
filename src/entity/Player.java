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
            this.playerIcon = ImageIO.read(getClass().getResourceAsStream("/textures/player/watermelon-char-right.png"));
        } catch (IOException e) {e.printStackTrace();}
    }

    private void setStartingValues() {
        
        int worldMiddleXPos = (gamePanel.getWorldWidth() / 2) - (gamePanel.getTileSize() / 2);
        int worldMiddleYPos = (gamePanel.getWorldHeight() / 2)  - (gamePanel.getTileSize() / 2);

        setWorldXPos(worldMiddleXPos);
        setWorldYPos(worldMiddleYPos);
        setSpeed(gamePanel.getFPS() / 48);
    }

    public void update() {
        if (keyHandler.getUpPressed()) {
            //System.out.println("up pressed");
            setWorldYPos(getWorldYPos() - getSpeed());
        }

        if (keyHandler.getDownPressed()) {
            setWorldYPos(getWorldYPos() + getSpeed());
        }

        if (keyHandler.getRightPressed()) {
            setWorldXPos(getWorldXPos() + getSpeed());
        }

        if (keyHandler.getLeftPressed()) {
            setWorldXPos(getWorldXPos() - getSpeed());
        }
    }

    public void paintComponent(Graphics2D graphics2d) {
        graphics2d.drawImage(this.playerIcon, gamePanel.getScreenXPos(), gamePanel.getScreenYPos(), gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
}
