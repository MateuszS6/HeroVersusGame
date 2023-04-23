package world;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import game.Game;

public class Tile extends Platform {
    public static final String TOP = "assets/tiles/witchcraft/tileset/outlined/top.png";
    public static final String TOP_LEFT = "assets/tiles/witchcraft/tileset/outlined/top_left.png";
    public static final String TOP_LEFT_END = "assets/tiles/witchcraft/tileset/outlined/top_left_end.png";
    public static final String TOP_RIGHT = "assets/tiles/witchcraft/tileset/outlined/top_right.png";
    public static final String TOP_RIGHT_END = "assets/tiles/witchcraft/tileset/outlined/top_right_end.png";
    public static final String TOP_TO_LEFT = "assets/tiles/witchcraft/tileset/outlined/top_to_left_join.png";
    public static final String BOTTOM = "assets/tiles/witchcraft/tileset/outlined/bottom.png";
    public static final String BOTTOM_LEFT = "assets/tiles/witchcraft/tileset/outlined/bottom_left.png";
    public static final String BOTTOM_RIGHT = "assets/tiles/witchcraft/tileset/outlined/bottom_right.png";
    public static final String BOTTOM_TO_RIGHT = "assets/tiles/witchcraft/tileset/outlined/bottom_to_right_join.png";
    public static final String LEFT = "assets/tiles/witchcraft/tileset/outlined/left.png";
    public static final String RIGHT = "assets/tiles/witchcraft/tileset/outlined/right.png";
    public static final String RIGHT_TO_BOTTOM = "assets/tiles/witchcraft/tileset/outlined/right_to_bottom_join.png";
    public static final String RIGHT_TO_TOP = "assets/tiles/witchcraft/tileset/outlined/right_to_top_join.png";

    public Tile(World w, String type, float x, float y) {
        super(w, Game.GRID_RES, Game.GRID_RES, x, y);
        addImage(new BodyImage(type, Game.GRID_RES * 2));
    }
}
