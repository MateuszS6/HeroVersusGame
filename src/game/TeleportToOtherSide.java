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
        if (e.getOtherBody() instanceof Player) {
            float xPos = (arena.getOtherSide((Barrier) e.getReportingBody()).getPosition().x) * 0.87f;
            float yPos = e.getOtherBody().getPosition().y;
            e.getOtherBody().setPosition(new Vec2(xPos, yPos));
        }
    }
}
