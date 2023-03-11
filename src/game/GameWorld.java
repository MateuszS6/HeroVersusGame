package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWorld extends World implements ActionListener {
    private Player player1;
    private Player player2;

    /** Initialise the game world. */
    public GameWorld() {
        // Stage
        Platform stage = new Platform(this, 7, 0.5f, 0, -12);
        stage.setFillColor(new Color(0, true));
        stage.setLineColor(new Color(0, true));

        // Suspended platform

        // Player 1
        player1 = new Player(this, new Knight(), true);
        player1.setPosition(new Vec2(-4, -9));

        // Player 2
        player2 = new Player(this, new Skeleton(), false);
        player2.setPosition(new Vec2(4, -9.5f));

        // Attacking collision detection
        if (player1.isAttacking()) {
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
        }

        System.out.println("test");
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}