package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/** Player class. */
public class Player extends Walker {
    private static Shape playerShape = new BoxShape(1, 2);
    private static BodyImage image = new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 4);

    /** Initialise a player. */
    public Player(World world) {
        super(world, playerShape);
        addImage(image);
    }

    public void attack() {
    }
}