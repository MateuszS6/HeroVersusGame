package arenas;

import game.BattleArena;
import world.Tile;

import java.awt.*;

public class Void extends BattleArena {
    public Void() {
        super(-15, 15, 9, -7.5f);

        // Background
        setBackground(Color.BLACK);

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
        addTile(Tile.RIGHT_TO_TOP, -11, 0);
        addTile(Tile.TOP, -9, 0);
        addTile(Tile.TOP_RIGHT_END, -7, 0);

        addTile(Tile.TOP, 19, 4);
        addTile(Tile.TOP_LEFT_END, 17, 4);

        addTile(Tile.TOP_LEFT_END, 3, -7);
        addTile(Tile.TOP_TO_LEFT, 5, -7);
        addTile(Tile.LEFT, 5, -5);
        addTile(Tile.TOP_LEFT, 5, -3);
        addTile(Tile.TOP, 7, -3);
        addTile(Tile.TOP_RIGHT_END, 9, -3);

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
        addTile(Tile.TOP_LEFT_END, 11, -11);
    }
}
