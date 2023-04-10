package player;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.GameWorld;

public class HitboxDetection implements SensorListener {
    private GameWorld world;
    private Player player;

    public HitboxDetection(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Player) if (player.isAttacking()) {
            System.out.println("hit");
        }
    }

    @Override
    public void endContact(SensorEvent e) {
        System.out.println("unhit");
    }
}
