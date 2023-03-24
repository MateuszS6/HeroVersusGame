package game;

import characters.Knight;
import characters.Skeleton;
import city.cs.engine.World;
import objects.FallToDeath;
import objects.HealthRefill;
import objects.HoveringBall;
import objects.Platform;
import org.jbox2d.common.Vec2;
import player.KeyBindings;
import player.Player;
import player.PlayerCollisions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWorld extends World implements ActionListener {
    private Player player1;
    private Player player2;
    private Vec2 p1StartPos;
    private Vec2 p2StartPos;
    private boolean respawn = true;

    /** Initialise a game world. */
    public GameWorld() {
        // World borders
        Platform left = new Platform(this, 0.5f, 20, -20.5f, 0);
        Platform right = new Platform(this, 0.5f, 20, 20.5f, 0);
        Platform ceiling = new Platform(this, 20, 0.5f, 0, 20);
        Platform death = new Platform(this, 20, 0.5f, 0, -20);
        death.addCollisionListener(new FallToDeath(this));

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

        // Player position
        p1StartPos = new Vec2(-4, -8.5f);
        p2StartPos = new Vec2(4, -9);

        // Player 1
        player1 = new Player(this, new Knight(), true);
        player1.setKeyBindings(new KeyBindings("w", "a", "d", "r"));
        player1.setPosition(p1StartPos);
        player1.addCollisionListener(new PlayerCollisions(this, player1));

        // Player 2
        player2 = new Player(this, new Skeleton(), false);
        player2.setKeyBindings(new KeyBindings());
        player2.setPosition(p2StartPos);
        player2.addCollisionListener(new PlayerCollisions(this, player2));

        Timer collectibleTimer = new Timer(10000, this);
        collectibleTimer.setRepeats(false);
        collectibleTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Collectible
        HealthRefill collectible = new HealthRefill(this, 0, -10);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean isRespawn() {
        return respawn;
    }

    public void setRespawn(boolean respawn) {
        this.respawn = respawn;
    }

    public void respawnPlayer(Player player) {
        if (player.getLives() <= 1) {
            player.setLives(0);
            player.setLives(0);
            player.destroy();
        } else if (player.getHealth() <= 0) {
            if (player == player1) {
                player.setFacingRight(true);
                player.setPosition(p1StartPos);
            } else if (player == player2) {
                player.setFacingRight(false);
                player.setPosition(p2StartPos);
            }
            player.setHealth(player.getMaxHealth());
            player.setLives(player.getLives() - 1);
        }
    }
}