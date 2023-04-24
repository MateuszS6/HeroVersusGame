package arenas;

import game.BattleArena;
import world.Tile;

import java.awt.*;

public class Void extends BattleArena {
    // TODO: Pick-ups that select random spawn location from list - spawn every set time, only when previous collected
    public Void() {
        super(-15, 15, 9, -7.5f);

        setBackground(Color.BLACK); // Background

        setDeathBarrier(this, -20);// Death barrier
    }

    @Override
    public void populate() {
        setTilePath("assets/tileset/witchcraft/tiles/outlined"); // File path for tiles

        placeTile(Tile.END_TOP_LEFT, -1, 9);
        for (int x = 1; x < 6; x = x + 2) placeTile(Tile.TOP, x, 9);
        placeTile(Tile.END_TOP_RIGHT, 7, 9);

        // Player 1 spawn
        for (int x = -19; x < -12; x = x + 2) placeTile(Tile.TOP, x, 4);
        placeTile(Tile.TOP_RIGHT, -11, 4);
        placeTile(Tile.RIGHT, -11, 2);
        placeTile(Tile.JOIN_TOP_RIGHT, -11, 0);
        placeTile(Tile.TOP, -9, 0);
        placeTile(Tile.END_TOP_RIGHT, -7, 0);

        placeTile(Tile.TOP, 19, 4);
        placeTile(Tile.END_TOP_LEFT, 17, 4);

        placeTile(Tile.END_TOP_LEFT, 3, -7);
        placeTile(Tile.JOIN_TOP_LEFT, 5, -7);
        placeTile(Tile.LEFT, 5, -5);
        placeTile(Tile.TOP_LEFT, 5, -3);
        placeTile(Tile.TOP, 7, -3);
        placeTile(Tile.END_TOP_RIGHT, 9, -3);

        for (int x = -19; x < -6; x = x + 2) placeTile(Tile.TOP, x, -11);
        placeTile(Tile.END_TOP_RIGHT, -5, -11);

        // Player 2 spawn
        for (int x = 13; x < 20; x = x + 2) placeTile(Tile.TOP, x, -11);
        placeTile(Tile.END_TOP_LEFT, 11, -11);
    }
}
