package game;

import city.cs.engine.*;

/** Player class. */
public class Player extends Walker {
    private static Shape playerShape = new BoxShape(1, 2);
    private static BodyImage image = new BodyImage("data/FreeKnight_v1/Colour2/Outline/120x80_gifs/__Idle.gif", 4);

    /** Player constructor. */
    public Player(World world) {
        super(world, playerShape);
        addImage(image);
    }

    public void idle() {
    }

    public void attack() {
    }
}