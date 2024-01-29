package tile;

import main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    Panel gp;
    public Tile[] tile;
    public int[][] mapTileNum;


    public TileManager(Panel gp){
        this.gp = gp;
        tile = new Tile[100];
        mapTileNum = new int [gp.maxWorldColumn][gp.maxWorldRow];
        getTileImage();
         loadMap("res/maps/world1.txt");
    }
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road00.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[2].collision = true;
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[3].collision = true;
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
            tile[4].collision = true;
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water04.png"));
            tile[5].collision = true;
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/hut.png"));
            tile[6].collision = true;
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));


        }catch(IOException e){
            e.printStackTrace();
        }
    }
     public void loadMap(String filePath){
        try{
            BufferedReader bufferedReader = null;
            bufferedReader = new BufferedReader(new FileReader(filePath));

            int row = 0;

            String line;
            while ((line = bufferedReader.readLine()) != null && row < gp.maxWorldRow) {
                String numbers[] = line.split(" ");
                for (int col = 0; col < gp.maxWorldColumn && col < numbers.length; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
     }
    public void draw(Graphics2D g2){
       int worldCol = 0;
       int worldRow = 0;

       while(worldCol < gp.maxWorldColumn && worldRow < gp.maxWorldRow) {
           int tileNum = mapTileNum[worldCol][worldRow];
           int worldX = worldCol * gp.tilesize;
           int worldY = worldRow * gp.tilesize;
           int screenX = worldX - gp.player.worldX + gp.player.screenX;
           int screenY = worldY - gp.player.worldY + gp.player.screenY;

           if(worldX + gp.tilesize > gp.player.worldX - gp.player.screenX && worldX - gp.tilesize < gp.player.worldX + gp.player.screenX &&
                   worldY + gp.tilesize > gp.player.worldY - gp.player.screenY && worldY - gp.tilesize < gp.player.worldY + gp.player.screenY){
               g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tilesize, gp.tilesize, null);
           }
           worldCol++;

           if(worldCol == gp.maxWorldColumn){
               worldCol = 0;
               worldRow++;

           }
       }
    }
}
