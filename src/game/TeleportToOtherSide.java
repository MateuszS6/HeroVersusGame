package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;
import player.Player;
import world.Barrier;

public class TeleportToOtherSide implements CollisionListener {
    private BattleArena arena;

    public TeleportToOtherSide(BattleArena arena) {
        this.arena = arena;
    }

    @Override
    public void collide(CollisionEvent e) {
        Barrier thisSide = (Barrier) e.getReportingBody();
        if (e.getOtherBody() instanceof Player player) {
            float xPos = (arena.getOtherSide(thisSide).getPosition().x) * 0.88f;
            float yPos = player.getPosition().y;
            Vec2 velocity = e.getVelocity();
            if (!player.isAttacking()) {
                player.setPosition(new Vec2(xPos, yPos));
                player.setLinearVelocity(velocity);
            }
        }
    }
}
