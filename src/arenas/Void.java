package arenas;

import game.BattleArena;
import world.Tile;

import java.awt.*;

public class Void extends BattleArena {
    // TODO: Pick-ups that select random spawn location from list - spawn every set time, only when previous collected
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
        addTile(Tile.END_TOP_LEFT, -1, 9);
        addTile(Tile.TOP, 1, 9);
        addTile(Tile.TOP, 3, 9);
        addTile(Tile.TOP, 5, 9);
        addTile(Tile.END_TOP_RIGHT, 7, 9);

        // Player 1 spawn
        addTile(Tile.TOP, -19, 4);
        addTile(Tile.TOP, -17, 4);
        addTile(Tile.TOP, -15, 4);
        addTile(Tile.TOP, -13, 4);
        addTile(Tile.TOP_RIGHT, -11, 4);
        addTile(Tile.RIGHT, -11, 2);
        addTile(Tile.JOIN_TOP_RIGHT, -11, 0);
        addTile(Tile.TOP, -9, 0);
        addTile(Tile.END_TOP_RIGHT, -7, 0);

        addTile(Tile.TOP, 19, 4);
        addTile(Tile.END_TOP_LEFT, 17, 4);

        addTile(Tile.END_TOP_LEFT, 3, -7);
        addTile(Tile.JOIN_TOP_LEFT, 5, -7);
        addTile(Tile.LEFT, 5, -5);
        addTile(Tile.TOP_LEFT, 5, -3);
        addTile(Tile.TOP, 7, -3);
        addTile(Tile.END_TOP_RIGHT, 9, -3);

        addTile(Tile.TOP, -19, -11);
        addTile(Tile.TOP, -17, -11);
        addTile(Tile.TOP, -15, -11);
        addTile(Tile.TOP, -13, -11);
        addTile(Tile.TOP, -11, -11);
        addTile(Tile.TOP, -9, -11);
        addTile(Tile.TOP, -7, -11);
        addTile(Tile.END_TOP_RIGHT, -5, -11);

        // Player 2 spawn
        addTile(Tile.TOP, 19, -11);
        addTile(Tile.TOP, 17, -11);
        addTile(Tile.TOP, 15, -11);
        addTile(Tile.TOP, 13, -11);
        addTile(Tile.END_TOP_LEFT, 11, -11);
    }
}
