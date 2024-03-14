package entity;

import java.awt.image.BufferedImage;

abstract class Entity {
    private int worldXPos;
    private int worldYPos;
    private int speed;

    // setters
    public void setWorldXPos(int XPosInput) {this.worldXPos = XPosInput;}
    public void setWorldYPos(int YPosInput) {this.worldYPos = YPosInput;}
    public void setSpeed(int speedInput) {this.speed = speedInput;}

    // getters
    public int getWorldXPos() {return this.worldXPos;}
    public int getWorldYPos() {return this.worldYPos;}
    public int getSpeed() {return this.speed;}

    protected BufferedImage playerIcon;
}
