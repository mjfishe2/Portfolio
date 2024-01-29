package main;

import entities.Character;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    //panel settings
    final int ogTileSize = 16; //16x16
    final int scale = 3;
    public final int tilesize = ogTileSize * scale; //48x48

   public final int maxScreenColumn = 16;
   public final int maxScreenRow = 12;

    public int screenWidth = tilesize * maxScreenColumn; //768 pixels
    public int screenHeight = tilesize * maxScreenRow; //576 pixels
    //world map settings
    public final int maxWorldColumn = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tilesize * maxWorldColumn;
    public final int worldHeight = tilesize * maxWorldRow;
    int FPS = 60;
    TileManager tileM = new TileManager(this);
    KBHandler kbh = new KBHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);

    public Character player = new Character(this,kbh);
    //Set default position for player
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    public Panel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kbh);
        this.setFocusable(true);
        this.requestFocusInWindow();
        player.getPlayerImage();
    }
    public void gameThreadStart(){
        gameThread = new Thread(this);
        gameThread.start();
        this.requestFocusInWindow();
        player.getPlayerImage();
    }
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            timer += (currentTime - lastTime);
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update(){
        player.update();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}
