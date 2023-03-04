package game;

import city.cs.engine.*;

/** Player class. */
public abstract class Player extends Walker {
    private static final Shape playerShape = new BoxShape(1, 2);
    private static final BodyImage image = new BodyImage("data/FreeKnight_v1/Colour2/Outline/120x80_gifs/__Idle.gif", 4);

    /** Player constructor. */
    public Player(World world) {
        super(world, playerShape);
        addImage(image);
    }

    public abstract void idle();
    public abstract void run();
    public abstract void jump();
    public abstract void attack();
}