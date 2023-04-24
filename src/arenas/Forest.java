package arenas;

import game.BattleArena;
import world.Tile;

public class Forest extends BattleArena {
    public Forest() {
        super(0, 0, 0, 0);

        setBackground("assets/background/forest/forest_resized.png");
    }

    @Override
    public void populate() {
        addTile(Tile.TOP, -19, -12);
    }
}
