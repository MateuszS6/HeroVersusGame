package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class FallToDeath implements CollisionListener {
    private GameWorld world;

    public FallToDeath(GameWorld world) {
        this.world = world;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Player) {
            ((Player) e.getOtherBody()).setHealth(0);
            System.out.println("attacked player health: " + ((Player) e.getOtherBody()).getHealth());
            world.respawnPlayer((Player) e.getOtherBody(), 0.5f);
        }
    }
}
