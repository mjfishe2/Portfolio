package main;

import tile.TileManager;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Zulda");

        Panel panel = new Panel();
        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.gameThreadStart();

    }
}
