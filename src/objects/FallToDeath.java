package objects;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.GameWorld;
import player.Player;

public class FallToDeath implements CollisionListener {
    private GameWorld world;

    public FallToDeath(GameWorld world) {
        this.world = world;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Player) {
            ((Player) e.getOtherBody()).setHealth(0);
            world.respawnPlayer((Player) e.getOtherBody(), 1);
        }
    }
}
