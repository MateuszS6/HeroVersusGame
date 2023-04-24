package arenas;

import game.BattleArena;
import world.Tile;

public class Forest extends BattleArena {
    public Forest() {
        super(-17, 17, -7, -8);

        setBackground("assets/background/forest/forest_resized.png"); // Background
    }

    @Override
    public void populate() {
        setTilePath("assets/tileset/village/tiles"); // File path for tiles

        for (int x = -19; x < 20; x += 2) {
            placeBlock(Tile.UNDER, x, -14);
            // Player spawns
            if (x < -5 || x > 5) placeBlock(Tile.TOP, x, -12);
        }
        placeBlock(Tile.JOIN_TOP_LEFT, -5, -12);
        for (int x = -3; x < 4; x += 2) placeBlock(Tile.UNDER, x, -12);
        placeBlock(Tile.JOIN_TOP_RIGHT, 5, -12);
        placeBlock(Tile.LEFT, -5, -10);
        for (int x = -3; x < 4; x += 2) placeBlock(Tile.UNDER, x, -10);
        placeBlock(Tile.RIGHT, 5, -10);
        placeBlock(Tile.TOP_LEFT, -5, -8);
        for (int x = -3; x < 4; x += 2) placeBlock(Tile.TOP, x, -8);
        placeBlock(Tile.TOP_RIGHT, 5, -8);

        for (int x = -19; x < -14; x += 2) placeBlock(Tile.ROW_CENTRE, x, -4);
        placeBlock(Tile.ROW_RIGHT, -13, -4);
        placeBlock(Tile.ROW_LEFT, 13, -4);
        for (int x = 15; x < 20; x += 2) placeBlock(Tile.ROW_CENTRE, x, -4);

        placeBlock(Tile.ROW_LEFT, 3, 0);
        placeBlock(Tile.ROW_RIGHT, 5, 0);

        placeBlock(Tile.ROW_LEFT, -11, 4);
        placeBlock(Tile.ROW_CENTRE, -9, 4);
        placeBlock(Tile.ROW_CENTRE, -7, 4);
        placeBlock(Tile.ROW_RIGHT, -5, 4);

        placeBlock(Tile.ROW_LEFT, 1, 10);
        placeBlock(Tile.ROW_CENTRE, 3, 10);
        placeBlock(Tile.ROW_CENTRE, 5, 10);
        placeBlock(Tile.ROW_CENTRE, 7, 10);
        placeBlock(Tile.ROW_TOP_RIGHT, 9, 10);
        placeBlock(Tile.ROW_BOTTOM_LEFT, 9, 8);
        placeBlock(Tile.ROW_CENTRE, 11, 8);
        placeBlock(Tile.ROW_CENTRE, 13, 8);
        placeBlock(Tile.ROW_CENTRE, 15, 8);
        placeBlock(Tile.ROW_RIGHT, 17, 8);
    }
}
