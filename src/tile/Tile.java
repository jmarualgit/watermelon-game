package tile;

import java.awt.image.BufferedImage;

public class Tile {
    
    private BufferedImage tileImage;
    private Boolean collisionAble;

    public BufferedImage getImage() {return this.tileImage;}
    public boolean isCollisionable() {return this.collisionAble;}

    public void setImage(BufferedImage imageInput) {this.tileImage = imageInput;};
    public void setCollisionable(boolean boolInput) {this.collisionAble = boolInput;}
}
