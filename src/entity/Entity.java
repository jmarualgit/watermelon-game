package entity;

import java.awt.image.BufferedImage;

abstract class Entity {
    private int xPos;
    private int yPos;
    private int speed;

    // setters
    public void setXPos(int XPosInput) {this.xPos = XPosInput;}
    public void setYPos(int YPosInput) {this.yPos = YPosInput;}
    public void setSpeed(int speedInput) {this.speed = speedInput;}

    // getters
    public int getXPos() {return this.xPos;}
    public int getYPos() {return this.yPos;}
    public int getSpeed() {return this.speed;}

    protected BufferedImage playerIcon;
}
