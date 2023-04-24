package arenas;

import game.BattleArena;
import world.Tile;

public class Forest extends BattleArena {
    public Forest() {
        super(0, 0, 0, 0);

        setBackground("assets/background/forest/forest_resized.png"); // Background
    }

    @Override
    public void populate() {
        setTilePath("assets/tileset/village/tiles"); // File path for tiles

        for (int x = -19; x < 20; x = x + 2) {
            placeTile(Tile.TOP, x, -12);
            placeTile(Tile.UNDER, x, -14);
        }

//        placeTile();
    }
}
