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

    @Override
    public void postStep(StepEvent stepEvent) {
        if (player.getLinearVelocity().y != 0)
            player.setMidAir(true);
        else
            player.setMidAir(false);
        System.out.println(player.isMidAir());
    }
}
