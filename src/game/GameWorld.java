package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/** Game world class. */
public class GameWorld extends World {
    /** Game world constructor. */
    public GameWorld() {
        super();

        // Ground platform
        BoxShape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // Suspended platform
        BoxShape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        // Character
        Knight knight1 = new Knight(this);
        knight1.setPosition(new Vec2(7, -9));
        // student.startWalking(2);
    }
}