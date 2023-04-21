package arenas;

import game.BattleArena;
import world.Platform;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Classic extends BattleArena implements ActionListener {
    public Classic() {
        super(-4, 4, -8.5f, -9);

        // Background image
        setBackground("assets/background/arena_with_stage.jpg");

        // Death barrier
        setDeathBarrier(this, -20);

        // Stage
        Platform stage = new Platform(this, 7, 2, 0, -13.5f);
        stage.setFillColor(new Color(0, true));
        stage.setLineColor(new Color(0, true));

        // Platforms
        Platform platform1 = new Platform(this, 4, 0.5f, -14, -8);
        Platform platform2 = new Platform(this, 4, 0.5f, 14, -8);
        Platform platform3 = new Platform(this, 4, 0.5f, 0, -3);
        Platform platform4 = new Platform(this, 4, 0.5f, -14, 2);
        Platform platform5 = new Platform(this, 4, 0.5f, 14, 2);

        // Hovering ball
//        HoveringBall annoyingBall = new HoveringBall(this, 3, 0, 8);

//        Timer collectibleTimer = new Timer(10000, this);
//        collectibleTimer.setRepeats(false);
//        collectibleTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Collectible
//        HealthRefill collectible = new HealthRefill(this, 0, -10);
    }
}
