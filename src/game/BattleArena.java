package game;

import characters.Knight;
import characters.Skeleton;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;
import player.Collisions;
import player.KeyBindings;
import player.Player;
import world.Barrier;
import world.FallToDeath;

import javax.swing.*;
import java.awt.*;

public abstract class BattleArena extends World {
    // TODO: 1 life, best of 3, winning player chooses next arena to play in
    private Image background;
    private final Player
            player1,
            player2;
    private Barrier deathBarrier;

    /** Initialise a game world. */
    public BattleArena(float x1, float x2, float y1, float y2) {
        // World borders TODO: Walking off-screen teleports player to opposite side
        Barrier left = new Barrier(this, 0.5f, 20, -20.5f, 0);
        Barrier right = new Barrier(this, 0.5f, 20, 20.5f, 0);

        // Player 1
        player1 = new Player(this, 1, new Knight(), new Vec2(x1, y1));
        player1.setKeyBindings(new KeyBindings("w", "a", "d", "r"));
        player1.addCollisionListener(new Collisions(this, player1));

        // Player 2
        player2 = new Player(this, 2, new Skeleton(), new Vec2(x2, y2));
        player2.setKeyBindings(new KeyBindings());
        player2.addCollisionListener(new Collisions(this, player2));
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(String filename) {
        background = new ImageIcon(filename).getImage();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Barrier getDeathBarrier() {
        return deathBarrier;
    }

    public void setDeathBarrier(World world, float halfWidth, float halfHeight, float x, float y) {
        deathBarrier = new Barrier(world, halfWidth, halfHeight, x, y);
        deathBarrier.addCollisionListener(new FallToDeath(this));
    }
}