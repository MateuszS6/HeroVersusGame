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

        addTile(Tile.TOP, -19, -12);
    }
}
