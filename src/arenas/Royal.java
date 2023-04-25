package arenas;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import game.BattleArena;
import org.jbox2d.common.Vec2;
import world.Platform;
import world.Tile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Royal extends BattleArena implements ActionListener {
    // TODO: 24/04/2023 WOODEN TILES???
    public Royal() {
        super(-4, 4, -8.5f, -9);

        // Background image
        setBackground("assets/background/arena_with_stage.jpg");

        // Death barrier
        setDeathBarrier(this, -20);

        // Stage
        Color transparent = new Color(0, 0, 0, 0);
        Platform stage = new Platform(this, 7, 2, 0, -13.5f);
        stage.setFillColor(transparent);
        stage.setLineColor(transparent);

        Platform platform2 = new Platform(this, 4, 0.5f, 14, -8);
        Platform platform3 = new Platform(this, 4, 0.5f, 0, -3);
        Platform platform4 = new Platform(this, 4, 0.5f, -14, 2);
        Platform platform5 = new Platform(this, 4, 0.5f, 14, 2);

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
    }
}
