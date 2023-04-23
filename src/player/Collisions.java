package player;

import city.cs.engine.BoxShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import game.BattleArena;
import world.HealthRefill;
import world.Platform;
import world.Tile;

public class Collisions implements CollisionListener {
    private final BattleArena world;
    private final Player player;

    public Collisions(BattleArena world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Platform platform) {
            if (player.isMidAir()) player.land();
        }

        if (e.getOtherBody() instanceof Player otherPlayer) {
            if (otherPlayer.isAttacking()) {
                player.setHealth(player.getHealth() - otherPlayer.getCharacter().getAttackDamage());
                System.out.println("Attacked player health: " + player.getHealth());

                player.respawn();
            }
        }

        if (e.getOtherBody() instanceof HealthRefill) if (player.getHealth() < player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
            e.getOtherBody().destroy();
        }
    }
}
