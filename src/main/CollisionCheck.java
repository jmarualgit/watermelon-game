package main;

import entity.Entity;
import tile.Tile;
import tile.TileManager;

public class CollisionCheck {
    
    GamePanel gamePanel;
    
    CollisionCheck (GamePanel gh) {
        this.gamePanel = gh;
    }

    public void checkCollissions(Entity entity) {

        // get hitbox border positions
        int hitboxLeftBorderX = gamePanel.getPlayer().getWorldXPos() + gamePanel.getPlayer().getHitbox().x;
        int hitboxRightBorderX = gamePanel.getPlayer().getWorldXPos() + gamePanel.getPlayer().getHitbox().x + gamePanel.getPlayer().getHitbox().width;
        int hitboxTopBorderY = gamePanel.getPlayer().getWorldYPos() + gamePanel.getPlayer().getHitbox().y;
        int hitboxBottomBorderY = gamePanel.getPlayer().getWorldYPos() + gamePanel.getPlayer().getHitbox().y + gamePanel.getPlayer().getHitbox().height;

        int hitboxLeftBorderColumnNum = hitboxLeftBorderX / gamePanel.getTileSize();
        int hitboxRightBorderColumnNum = hitboxRightBorderX / gamePanel.getTileSize();
        int hitboxTopBorderRowNum = hitboxTopBorderY / gamePanel.getTileSize();
        int hitboxBottomBorderRowNum = hitboxBottomBorderY / gamePanel.getTileSize();

        // these two tiles are the two corners of the hitbox we check for collision
        Tile tileOne, tileTwo;

        switch (gamePanel.getPlayer().getDirection()) {
            case "up":
                // get the tile row number that the entity is gonna hit
                hitboxTopBorderRowNum = (hitboxTopBorderY - entity.getSpeed()) / gamePanel.getTileSize();

                // both tiles have the same row number but different column number
                // top left tile
                tileOne = TileManager.getTile(hitboxLeftBorderColumnNum, hitboxTopBorderRowNum);

                // top right tile
                tileTwo = TileManager.getTile(hitboxRightBorderColumnNum, hitboxTopBorderRowNum);

                // check if the tiles are collisionable
                if (tileOne.isCollisionable() || tileTwo.isCollisionable()) {
                    entity.setHasCollided(true);
                }

                break;
            
            case "down":
                hitboxBottomBorderRowNum = (hitboxBottomBorderY + entity.getSpeed()) / gamePanel.getTileSize();

                // both tiles have the same row number but different column numbers
                // bottom left tile
                tileOne = TileManager.getTile(hitboxLeftBorderColumnNum, hitboxBottomBorderRowNum);

                // bottom right tile
                tileTwo = TileManager.getTile(hitboxRightBorderColumnNum, hitboxBottomBorderRowNum);

                if (tileOne.isCollisionable() || tileTwo.isCollisionable()) {entity.setHasCollided(true);}

                break;
            
            case "right":
                hitboxRightBorderColumnNum = (hitboxRightBorderX + entity.getSpeed()) / gamePanel.getTileSize();

                // both tiles have the same column number but different row numbers
                // top right border
                tileOne = TileManager.getTile(hitboxRightBorderColumnNum, hitboxTopBorderRowNum);

                // bottom right border
                tileTwo = TileManager.getTile(hitboxRightBorderColumnNum, hitboxBottomBorderRowNum);

                if (tileOne.isCollisionable() || tileTwo.isCollisionable()) {entity.setHasCollided(true);}

                break;

            case "left":
                hitboxLeftBorderColumnNum =  (hitboxLeftBorderX - entity.getSpeed()) / gamePanel.getTileSize();

                // these two tiles will have the same column number but different row numbers
                // top left border
                tileOne = TileManager.getTile(hitboxLeftBorderColumnNum, hitboxTopBorderRowNum);

                // bottom left border
                tileTwo = TileManager.getTile(hitboxLeftBorderColumnNum, hitboxBottomBorderRowNum);

                if (tileOne.isCollisionable() || tileTwo.isCollisionable()) {entity.setHasCollided(true);}

                break;
        }
    }
}
