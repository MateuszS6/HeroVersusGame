package world;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import game.Game;

public class Tile extends Platform {
    private static final String PATH = "assets/tileset/witchcraft/tiles/outlined/";
    public static final String TOP = PATH + "top.png";
    public static final String TOP_LEFT = PATH + "top_left.png";
    public static final String TOP_LEFT_END = PATH + "top_left_end.png";
    public static final String TOP_RIGHT = PATH + "top_right.png";
    public static final String TOP_RIGHT_END = PATH + "top_right_end.png";
    public static final String TOP_TO_LEFT = PATH + "top_to_left_join.png";
    public static final String BOTTOM = PATH + "bottom.png";
    public static final String BOTTOM_LEFT = PATH + "bottom_left.png";
    public static final String BOTTOM_RIGHT = PATH + "bottom_right.png";
    public static final String BOTTOM_TO_RIGHT = PATH + "bottom_to_right_join.png";
    public static final String LEFT = PATH + "left.png";
    public static final String RIGHT = PATH + "right.png";
    public static final String RIGHT_TO_BOTTOM = PATH + "right_to_bottom_join.png";
    public static final String RIGHT_TO_TOP = PATH + "right_to_top_join.png";

    public Tile(World w, String type, float x, float y) {
        super(w, Game.GRID_RES, Game.GRID_RES, x, y);
        addImage(new BodyImage(type, Game.GRID_RES * 2));
    }
}
