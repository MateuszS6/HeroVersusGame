package arenas;

import game.BattleArena;
import world.Tile;

import java.awt.*;

public class Void extends BattleArena {
    public Void() {
        super(-15, 15, 9, -7.5f);

        // Background
        setBackground("assets/background/void.jpg");

        // Death barrier
        setDeathBarrier(this, -20);

        // Populate world with tiles
        populate();
    }

    @Override
    public void populate() {
        addTile(Tile.TOP_LEFT_END, -1, 9);
        addTile(Tile.TOP, 1, 9);
        addTile(Tile.TOP, 3, 9);
        addTile(Tile.TOP, 5, 9);
        addTile(Tile.TOP_RIGHT_END, 7, 9);

        // Player 1 spawn
        addTile(Tile.TOP, -19, 4);
        addTile(Tile.TOP, -17, 4);
        addTile(Tile.TOP, -15, 4);
        addTile(Tile.TOP, -13, 4);
        addTile(Tile.TOP_RIGHT, -11, 4);
        addTile(Tile.RIGHT, -11, 2);
        addTile(Tile.BOTTOM_RIGHT, -11, 0);
        addTile(Tile.BOTTOM, -13, 0);
        addTile(Tile.BOTTOM, -15, 0);
        addTile(Tile.BOTTOM, -17, 0);
        addTile(Tile.BOTTOM, -19, 0);

        addTile(Tile.TOP, 19, 4);
        addTile(Tile.TOP_LEFT_END, 17, 4);

        addTile(Tile.TOP_LEFT_END, -3, -5);
        addTile(Tile.TOP, -1, -5);
        addTile(Tile.TOP, 1, -5);
        addTile(Tile.TOP, 3, -5);
        addTile(Tile.TOP_TO_LEFT, 5, -5);
        addTile(Tile.LEFT, 5, -3);
        addTile(Tile.TOP_LEFT, 5, -1);
        addTile(Tile.TOP, 7, -1);
        addTile(Tile.TOP_RIGHT_END, 9, -1);

        addTile(Tile.TOP, -19, -11);
        addTile(Tile.TOP, -17, -11);
        addTile(Tile.TOP, -15, -11);
        addTile(Tile.TOP, -13, -11);
        addTile(Tile.TOP, -11, -11);
        addTile(Tile.TOP, -9, -11);
        addTile(Tile.TOP, -7, -11);
        addTile(Tile.TOP_RIGHT_END, -5, -11);

        // Player 2 spawn
        addTile(Tile.TOP, 19, -11);
        addTile(Tile.TOP, 17, -11);
        addTile(Tile.TOP, 15, -11);
        addTile(Tile.TOP, 13, -11);
        addTile(Tile.TOP, 11, -11);
        addTile(Tile.TOP_LEFT, 9, -11);
        addTile(Tile.LEFT, 9, -13);
        addTile(Tile.LEFT, 9, -15);
    }
}
