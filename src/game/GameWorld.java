package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWorld extends World implements ActionListener {
    private Player player1;
    private Player player2;

    /**
     * Initialise the game world.
     */
    public GameWorld() {
        // World borders
        Platform left = new Platform(this, 0.5f, 30, -20.5f, 0);
        Platform right = new Platform(this, 0.5f, 30, 20.5f, 0);
        Platform ceiling = new Platform(this, 20, 0.5f, 0, 20);
        Platform death = new Platform(this, 20, 0.5f, 0, -30);

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
        HoveringBall annoyingBall = new HoveringBall(this, 3, 0, 8);
        annoyingBall.hover();

        // Player 1
        player1 = new Player(this, new Knight(), true);
        player1.setKeyBindings(new KeyBindings("w", "a", "d", "r"));
        player1.setPosition(new Vec2(-4, -8.5f));

        // Player 2
        player2 = new Player(this, new Skeleton(), false);
        player2.setKeyBindings(new KeyBindings());
        player2.setPosition(new Vec2(4, -9));

        // Attacking collision detection
        /* if (player1.isAttacking()) {
            if (!player1.isFacingRight() && player1.getLeftAttackArea().contains(player2.getPosition()))
                System.out.println("player 1 left-attacked player 2");
            else if (player1.isFacingRight() && player1.getRightAttackArea().contains(player2.getPosition()))
                System.out.println("player 1 right-attacked player 2");
        }
        if (player2.isAttacking()) {
            if (!player2.isFacingRight() && player2.getLeftAttackArea().contains(player1.getPosition()))
                System.out.println("player 2 left-attacked player 1");
            else if (player2.isFacingRight() && player2.getRightAttackArea().contains(player1.getPosition()))
                System.out.println("player 2 right-attacked player 1");
        } */
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}