package tile;

import java.awt.image.BufferedImage;

public class Tile {
    
    private BufferedImage tileImage;

    public BufferedImage getImage() {return this.tileImage;}
    public void setImage(BufferedImage imageInput) {this.tileImage = imageInput;};
}
