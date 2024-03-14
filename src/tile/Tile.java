package tile;

import java.awt.image.BufferedImage;

public class Tile {
    
    private BufferedImage tileImage;
    private Boolean collisionAble;

    public BufferedImage getImage() {return this.tileImage;}
    public boolean isCollisionable() {return this.collisionAble;}

    public void setImage(BufferedImage imageInput) {this.tileImage = imageInput;};
    public void setCollisionable(boolean boolInput) {this.collisionAble = boolInput;}

    // TODO switch getTile into here; make it so u put the column and row in and it'll return a tile instead of the number
}
