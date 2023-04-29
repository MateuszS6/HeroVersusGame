package world;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.BattleArena;
import player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FallToDeath implements CollisionListener, ActionListener {
    private final BattleArena arena;

    public FallToDeath(BattleArena w) {
        arena = w;
    }

    @Override
    public void collide(CollisionEvent e) {
        Barrier deathBarrier = (Barrier) e.getReportingBody();
        if (e.getOtherBody() instanceof Player player) {
            deathBarrier.removeAllCollisionListeners();
            player.setHealth(0);
            player.respawn();

            Timer timer = new Timer(500, this);
            timer.setRepeats(false);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        arena.getDeathBarrier().addCollisionListener(this);
    }
}
