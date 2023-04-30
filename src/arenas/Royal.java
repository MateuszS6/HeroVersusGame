package arenas;

import game.BattleArena;
import world.Platform;
import world.Tile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Royal extends BattleArena implements ActionListener {
    // TODO: 24/04/2023 WOODEN TILES???
    public Royal() {
        super(-4, 4, -8, -9);

        setName("Royal Arena");

        setBackground("assets/background/arena_with_stage.jpg");

        setDeathZone(this, -20);

        // Stage (player spawns)
        Color transparent = new Color(0, 0, 0, 0);
        Platform stage = new Platform(this, 7, 2, 0, -13.5f);
        stage.setFillColor(transparent);
        stage.setLineColor(transparent);

        // Hovering ball
//        HoveringBall annoyingBall = new HoveringBall(this, 3, 0, 8);

//        Timer collectibleTimer = new Timer(10000, this);
//        collectibleTimer.setRepeats(false);
//        collectibleTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Collectible
//        HealthRefill collectible = new HealthRefill(this, 0, -10);
    }

    @Override
    public void populate() {
        setTilePath("assets/tileset/grasslands/tiles");

        placeBlock(Tile.ROW_LEFT, -17, -7);
        placeBlock(Tile.ROW, -15, -7);
        placeBlock(Tile.ROW, -13, -7);
        placeBlock(Tile.ROW_RIGHT, -11, -7);

        placeBlock(Tile.ROW_LEFT, 11, -7);
        placeBlock(Tile.ROW, 13, -7);
        placeBlock(Tile.ROW, 15, -7);
        placeBlock(Tile.ROW_RIGHT, 17, -7);

        placeBlock(Tile.ROW_LEFT, -3, -2);
        placeBlock(Tile.ROW, -1, -2);
        placeBlock(Tile.ROW, 1, -2);
        placeBlock(Tile.ROW_RIGHT, 3, -2);

        for (int x = -19; x < -12; x += 2) placeBlock(Tile.ROW, x, 3);
        placeBlock(Tile.ROW_RIGHT, -11, 3);
        placeBlock(Tile.ROW_LEFT, 11, 3);
        for (int x = 13; x < 20; x += 2) placeBlock(Tile.ROW, x, 3);

        placeBlock(Tile.ROW_LEFT, -3, 8);
        placeBlock(Tile.ROW, -1, 8);
        placeBlock(Tile.ROW, 1, 8);
        placeBlock(Tile.ROW_RIGHT, 3, 8);
    }
}
