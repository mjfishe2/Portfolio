package entities;

import main.KBHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

public class Character extends Entity {
    main.Panel gp;
    KBHandler kbh;
    public final int screenX;
    public final int screenY;

    public Character(main.Panel gp, KBHandler kbh) {
        this.gp = gp;
        this.kbh = kbh;
        screenX = gp.screenWidth / 2 - gp.tilesize / 2;
        screenY = gp.screenHeight / 2 - gp.tilesize / 2;
        solidArea = new Rectangle(8, 16, 32, 32);
        setDefaultVal();
        getPlayerImage();
    }

    public void setDefaultVal() {
        worldX = gp.tilesize * 23;
        worldY = gp.tilesize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/walkingaway.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/walkingaway2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/walkingfrontface.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/walkingfrontface2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/walkingleft.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/walkingleft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/walkingright.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/walkingright2.png"));

        } catch (IOException e) {
            System.err.println("Error loading images: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void update() {
        if (kbh.upPressed) {
            direction = "up";

        } else if (kbh.downPressed == true) {
            direction = "down";

        } else if (kbh.leftPressed == true) {
            direction = "left";

        } else if (kbh.rightPressed == true) {
            direction = "right";
        } else {
            direction = "idle";
        }
        //check tile collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //if collision false player can move
        if(collisionOn == false){
            switch(direction){
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
                case "idle":
                    break;
            }
        }
        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "idle":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tilesize, gp.tilesize, null);
    }

}
