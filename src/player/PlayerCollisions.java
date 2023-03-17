package player;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.GameWorld;
import objects.HealthRefill;
import objects.Platform;

public class PlayerCollisions implements CollisionListener {
    private GameWorld world;
    private Player player;

    public PlayerCollisions(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Platform) {
            if (!player.isAttacking()) {
                player.removeAllImages();
                if (player.isFacingRight())
                    player.addImage(player.getCharacter().getIdleRightImage());
                else
                    player.addImage(player.getCharacter().getIdleLeftImage());
            }
        }
        if (e.getOtherBody() instanceof Player ) {
            if (player.isAttacking()) {
                ((Player) e.getOtherBody()).setHealth(((Player) e.getOtherBody()).getHealth() - player.getCharacter().getAttackDamage());
                System.out.println("attacked player health: " + ((Player) e.getOtherBody()).getHealth());
                world.respawnPlayer((Player) e.getOtherBody(), 1);
            }
        }
        if (e.getOtherBody() instanceof HealthRefill) {
            if (player.getHealth() < player.getMaxHealth()) {
                player.setHealth(player.getMaxHealth());
                e.getOtherBody().destroy();
            }
        }
    }
}