package game;

import city.cs.engine.*;

public class PlayerCollisions implements CollisionListener {
    private Player player;

    public PlayerCollisions(Player player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
    }
}
