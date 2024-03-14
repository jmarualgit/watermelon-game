package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.util.Arrays;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
    
    GamePanel gamePanel;

    private static Tile[] tileImages;
    private static int[][] worldMapTileNumbers;

    public TileManager (GamePanel gp) {
        this.gamePanel = gp;

        tileImages = new Tile[4];
        worldMapTileNumbers = new int[gamePanel.getMaxWorldColumns()][gamePanel.getMaxWorldRows()];

        getTileImage();
        loadMapData("/textures/world-files/world01.txt");

        //System.out.println(Arrays.deepToString(worldMapTileNumbers));
    }
    
    private void getTileImage() {
        try {
            tileImages[0] = new Tile();
            tileImages[0].setImage(ImageIO.read(getClass().getResourceAsStream("/textures/map-textures/grass.png")));

            tileImages[1] = new Tile();
            tileImages[1].setImage(ImageIO.read(getClass().getResourceAsStream("/textures/map-textures/stone.png")));

            tileImages[2] = new Tile();
            tileImages[2].setImage(ImageIO.read(getClass().getResourceAsStream("/textures/map-textures/water.png")));

            tileImages[3] = new Tile();
            tileImages[3].setImage(ImageIO.read(getClass().getResourceAsStream("/textures/map-textures/tree.png")));
        } catch (IOException e) {e.printStackTrace();};
    }

    // to handle putting world data .txt files into code through a [][] array
    private void loadMapData(String filepath) {
        try {
            // read the world data file
            InputStream inputStream =  getClass().getResourceAsStream(filepath);

            // put the data into a reader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // counters to move between spaces in the [][]
            int currentColumnNum = 0;
            int currentRowNum = 0;

            // while loop to put the txt file into worldMapTiles[][]
            // keep going until reach max columns and rows
            while (currentColumnNum < gamePanel.getMaxWorldColumns() && currentRowNum < gamePanel.getMaxWorldRows()) {

                // set line (row) to read
                String line = bufferedReader.readLine();
                //System.out.println("current line: " + line);

                // put all of the characters in line in an array
                // they are separated by using the separating value " "
                String numbers[] = line.split(" ");

                //System.out.println("BEFORE LOOP || column: " + currentColumnNum + "; row: " + currentRowNum);

                // go through the first line
                while (currentColumnNum < gamePanel.getMaxWorldColumns()) {
                    // convert to int
                    int numToInput = Integer.parseInt(numbers[currentColumnNum]);

                    // put into main array
                    worldMapTileNumbers[currentColumnNum][currentRowNum] = numToInput;

                    currentColumnNum++;
                } // end while loop for each row

                //System.out.println("AFTER LOOP || column: " + currentColumnNum + "; row: " + currentRowNum);

                // to reset columnNum value and then increment row #
                if (currentColumnNum == gamePanel.getMaxWorldColumns()) {
                    
                    currentColumnNum = 0;
                    currentRowNum++;
                }
            } // end while loop for the whole [][]

            bufferedReader.close();
        } catch (Exception e) {}
    }

    // drawing the world map from the [][] array
    public void drawWorld(Graphics2D graphics2D) {
        int currentColumnNum = 0;
        int currentRowNum = 0;

        while (currentColumnNum < gamePanel.getMaxWorldColumns() && currentRowNum < gamePanel.getMaxWorldRows()) {

            int tileToDrawAsNumber = worldMapTileNumbers[currentColumnNum][currentRowNum];
            BufferedImage tileToDraw = tileImages[tileToDrawAsNumber].getImage();

            // get the tile's xPos in the world as a function of tileSize and column number
            int tileWorldXPos = gamePanel.getTileSize() * currentColumnNum;
            int tileWorldYPos = gamePanel.getTileSize() * currentRowNum;

            // [translate]/get the position of the title in reference to the center
            // tileWorldX/YPos for each tile at [columnNum][rowNum] as well as screenX/YPos stays constant, it is only the the player's worldXPos that deteremines the change
            int tileScreenXPos = tileWorldXPos + gamePanel.getScreenXPos() - gamePanel.getPlayerWorldXPos();
            int tileScreenYPos = tileWorldYPos + gamePanel.getScreenYPos() - gamePanel.getPlayerWorldYPos();

            graphics2D.drawImage(tileToDraw, tileScreenXPos, tileScreenYPos, gamePanel.getTileSize(), gamePanel.getTileSize(), null);

            currentColumnNum++;

            if (currentColumnNum == gamePanel.getMaxWorldColumns()) {
                currentColumnNum = 0;
                currentRowNum++;
            }
        }
    }
}
