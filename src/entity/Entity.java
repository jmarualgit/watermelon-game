package entity;

import java.awt.image.BufferedImage;

abstract class Entity {
    private int playerWorldXPos;
    private int playerWorldYPos;
    private int speed;

    // setters
    public void setPlayerWorldXPos(int XPosInput) {this.playerWorldXPos = XPosInput;}
    public void setPlayerWorldYPos(int YPosInput) {this.playerWorldYPos = YPosInput;}
    public void setSpeed(int speedInput) {this.speed = speedInput;}

    // getters
    public int getPlayerWorldXPos() {return this.playerWorldXPos;}
    public int getPlayerWorldYPos() {return this.playerWorldYPos;}
    public int getSpeed() {return this.speed;}

    protected BufferedImage playerIcon;
}
