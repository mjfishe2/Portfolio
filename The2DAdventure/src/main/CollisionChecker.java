package main;

import entities.Character;
import entities.Entity;

public class CollisionChecker {
    Panel gp;

    public CollisionChecker(Panel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tilesize;
        int entityRightCol = entityRightWorldX/gp.tilesize;
        int entityTopRow = entityTopWorldY/gp.tilesize;
        int entityBottomRow = entityBottomWorldY/gp.tilesize;

        int tilenum1, tilenum2;

        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tilesize;
                tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomRow + entity.speed)/gp.tilesize;
                tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tilesize;
                tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tilenum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX - entity.speed)/gp.tilesize;
                tilenum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}

