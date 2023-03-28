package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import player.Player;

public class TestStepListener implements StepListener {
    private GameWorld world;
    private Player player;

    public TestStepListener(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (player.getPosition().y < -19) {
            System.out.println("respawn");
            world.respawnPlayer(player);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
