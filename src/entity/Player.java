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

        // tileSizes are 64px
        getHitbox().x = gamePanel.getTileSize() / 6;            // 64 / 8 = 8
        getHitbox().y = gamePanel.getTileSize() / 3;            // 8
        getHitbox().width = gamePanel.getTileSize() / 3 * 2;    // 64 / 4 = 16; 16 * 2 = 32;
        getHitbox().height = getHitbox().width;

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
        setDirection("right");
        setHasCollided(false);
    }

    public void update() {
        if (keyHandler.getUpPressed() || keyHandler.getRightPressed() || keyHandler.getDownPressed() || keyHandler.getLeftPressed()) {
            // set their directions for collisionCheck to use
            if (keyHandler.getUpPressed()) {
                //System.out.println("up pressed");
                setDirection("up");
            }

            if (keyHandler.getDownPressed()) {setDirection("down");}

            if (keyHandler.getRightPressed()) {setDirection("right");}

            if (keyHandler.getLeftPressed()) {setDirection("left");}

            setHasCollided(false);
            gamePanel.getCollisionChecker().checkCollissions(this);

            if (!hasCollided()) {
                if (keyHandler.getUpPressed()) {
                    setWorldYPos(getWorldYPos() - getSpeed());
                }
                
                if (keyHandler.getDownPressed()) {setWorldYPos(getWorldYPos() + getSpeed());}
        
                if (keyHandler.getRightPressed()) {setWorldXPos(getWorldXPos() + getSpeed());}
        
                if (keyHandler.getLeftPressed()) {setWorldXPos(getWorldXPos() - getSpeed());}
            }
        }
    }

    public void paintComponent(Graphics2D graphics2d) {
        graphics2d.drawImage(this.playerIcon, gamePanel.getScreenXPos(), gamePanel.getScreenYPos(), gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
}
