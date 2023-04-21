package arenas;

import game.BattleArena;
import world.Tile;

import java.awt.*;

public class Void extends BattleArena {
    public Void() {
        super(-15, 4, 9, -9);

        setBackground(Color.BLACK); // Background colour

        setDeathBarrier(this, -20); // Death barrier

        populate(); // Populate world with tiles
    }

    @Override
    public void populate() {
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

        addTile(Tile.TOP_LEFT_END, 1, -1);
        addTile(Tile.TOP, 3, -1);
        addTile(Tile.TOP, 5, -1);
        addTile(Tile.TOP_RIGHT_END, 7, -1);
    }
}
