package game;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private Player player1;
    private Player player2;

    /** Initialise the game world. */
    public GameWorld() {
        // Ground
        BoxShape shape = new BoxShape(18, 1.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));

        // Suspended platform
        BoxShape platformShape = new BoxShape(2.5f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-7.5f, -5.5f));

        // Character
        player1 = new Player(this, new Knight());
        player1.setPosition(new Vec2(8, -9));
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}