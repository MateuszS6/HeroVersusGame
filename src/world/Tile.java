package world;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import game.Game;

public class Tile extends Platform {
    private static final String PATH = "assets/tileset/witchcraft/tiles/outlined/";
    public static final String TOP = PATH + "top.png";
    public static final String LEFT = PATH + "left.png";
    public static final String RIGHT = PATH + "right.png";
    public static final String BOTTOM = PATH + "bottom.png";
    public static final String TOP_LEFT = PATH + "top_left.png";
    public static final String TOP_RIGHT = PATH + "top_right.png";
    public static final String BOTTOM_LEFT = PATH + "bottom_left.png";
    public static final String BOTTOM_RIGHT = PATH + "bottom_right.png";
    public static final String END_TOP_LEFT = PATH + "end_top_left.png";
    public static final String END_TOP_RIGHT = PATH + "end_top_right.png";
    public static final String JOIN_TOP_LEFT = PATH + "join_top_left.png";
    public static final String JOIN_TOP_RIGHT = PATH + "join_top_right.png";
    public static final String JOIN_BOTTOM_LEFT = PATH + "join_bottom_left.png";
    public static final String JOIN_BOTTOM_RIGHT = PATH + "join_bottom_right.png";

    public Tile(World w, String type, float x, float y) {
        super(w, Game.GRID_RES, Game.GRID_RES, x, y);
        addImage(new BodyImage(type, Game.GRID_RES * 2));
    }
}
