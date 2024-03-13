package entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    
    GamePanel gamePanel;
    KeyHandler keyHandler;

    final int SCREEN_X_POS;
    final int SCREEN_Y_POS;

    final int CENTER_IMBALANCE_POS_BUFFER;

    public Player (GamePanel gp, KeyHandler kh) {
        this.gamePanel = gp;
        this.keyHandler = kh;

        CENTER_IMBALANCE_POS_BUFFER = gamePanel.getTileSize() / 2;

        SCREEN_X_POS = (gamePanel.getScreenWidth() / 2) - CENTER_IMBALANCE_POS_BUFFER;
        SCREEN_Y_POS = (gamePanel.getScreenHeight() / 2) - CENTER_IMBALANCE_POS_BUFFER;

        setStartingValues();
        getImage();
    }

    private void getImage() {
        try {
            this.playerIcon = ImageIO.read(getClass().getResourceAsStream("/textures/player/watermelon-char-right.png"));
        } catch (IOException e) {e.printStackTrace();}
    }

    private void setStartingValues() {
        
        int worldMiddleXPos = gamePanel.getWorldWidth() / 2;
        int worldMiddleYPos = gamePanel.getWorldHeight() / 2;

        setPlayerWorldXPos(worldMiddleXPos);
        setPlayerWorldYPos(worldMiddleYPos);
        setSpeed(gamePanel.getFPS() / 48);
    }

    public void update() {
        if (keyHandler.getUpPressed()) {
            //System.out.println("up pressed");
            setPlayerWorldYPos(getPlayerWorldYPos() - getSpeed());
        }

        if (keyHandler.getDownPressed()) {
            setPlayerWorldYPos(getPlayerWorldYPos() + getSpeed());
        }

        if (keyHandler.getRightPressed()) {
            setPlayerWorldXPos(getPlayerWorldXPos() + getSpeed());
        }

        if (keyHandler.getLeftPressed()) {
            setPlayerWorldXPos(getPlayerWorldXPos() - getSpeed());
        }
    }

    public void paintComponent(Graphics2D graphics2d) {
        graphics2d.drawImage(this.playerIcon, SCREEN_X_POS, SCREEN_Y_POS, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
}
