package arenas;

import game.BattleArena;
import world.Platform;
import world.Tile;

import java.awt.*;

public class Void extends BattleArena {
    public Void() {
        super(-4, 4, -8.5f, -9);

        // Background colour
        setBackground(Color.BLACK);

        // Death barrier
        setDeathBarrier(this, -20);

        Platform stage = new Platform(this, 7, 2, 0, -13.5f);

        new Tile(this, Tile.RIGHT_TO_TOP, -1, 1);
        new Tile(this, Tile.TOP, 1, 1);
        new Tile(this, Tile.TOP_RIGHT, 3, 1);
    }
}
