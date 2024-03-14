package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private int worldXPos;
    private int worldYPos;
    private int speed;
    private String direction;
    private Rectangle hitbox = new Rectangle();
    private boolean hasCollided;

    // setters
    public void setWorldXPos(int XPosInput) {this.worldXPos = XPosInput;}
    public void setWorldYPos(int YPosInput) {this.worldYPos = YPosInput;}
    public void setSpeed(int speedInput) {this.speed = speedInput;}
    public void setDirection(String directionInput) {this.direction = directionInput;}
    public void setHasCollided(boolean boolInput) {this.hasCollided = boolInput;}

    // getters
    public int getWorldXPos() {return this.worldXPos;}
    public int getWorldYPos() {return this.worldYPos;}
    public int getSpeed() {return this.speed;}
    public String getDirection() {return this.direction;}
    public boolean hasCollided() {return this.hasCollided;}
    public Rectangle getHitbox() {return this.hitbox;}

    protected BufferedImage playerIcon;
}
