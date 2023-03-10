package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class PlayerStepListener implements StepListener {
    private GameView view;
    private Player player;

    public PlayerStepListener(GameView view, Player player) {
        this.view = view;
        this.player = player;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    /** If the player is moving vertically, set isMidAir to true. */
    @Override
    public void postStep(StepEvent stepEvent) {
        player.setMidAir(player.getLinearVelocity().y != 0);
    }
}
