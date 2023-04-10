package player;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.GameWorld;

public class HitListener implements StepListener {
    private GameWorld world;
    private Player player;

    public HitListener(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public void beginContact(SensorEvent e) {
        if (e.getContactBody() instanceof Player) {
            ((Player) e.getContactBody()).setHealth(((Player) e.getContactBody()).getHealth() - player.getCharacter().getAttackDamage());
            System.out.println("attacked player health: " + ((Player) e.getContactBody()).getHealth());
            world.respawnPlayer((Player) e.getContactBody());
        }
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
