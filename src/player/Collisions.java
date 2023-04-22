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
    private BattleArena world;
    private Player player;

    public Collisions(BattleArena world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        /*if (e.getOtherBody() instanceof StaticBody) if (!player.isAttacking()) {
            player.removeAllImages();
            player.addImage(player.getCharacter().getIdleImage());
        }*/

        if (e.getOtherBody() instanceof Player) if (((Player) e.getOtherBody()).isAttacking()) {
            player.setHealth(player.getHealth() - ((Player) e.getOtherBody()).getCharacter().getAttackDamage());
            System.out.println("Attacked player health: " + player.getHealth());

            player.respawn();
        }

        if (e.getOtherBody() instanceof HealthRefill) if (player.getHealth() < player.getMaxHealth()) {
            player.setHealth(player.getMaxHealth());
            e.getOtherBody().destroy();
        }
    }
}
