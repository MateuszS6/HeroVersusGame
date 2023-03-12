package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PlayerCollisions implements CollisionListener {
    private Player player;

    public PlayerCollisions(Player player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Platform) {
            /* player.removeAllImages();
            if (player.isFacingRight())
                player.addImage(player.getCharacter().getIdleRightImage());
            else
                player.addImage(player.getCharacter().getIdleLeftImage()); */
            player.setMidAir(false);
        }
    }
}
