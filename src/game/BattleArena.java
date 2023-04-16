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
    private Image background;
    private final Player PLAYER_1;
    private final Player PLAYER_2;
    private Barrier deathBarrier;

    /** Initialise a game world. */
    public BattleArena(Vec2 startPos1, Vec2 startPos2) {
        // World borders TODO: Walk off screen teleports to opposite side
        Barrier left = new Barrier(this, 0.5f, 20, -20.5f, 0);
        Barrier right = new Barrier(this, 0.5f, 20, 20.5f, 0);

        // Player 1
        PLAYER_1 = new Player(this, 1, new Knight(), startPos1);
        PLAYER_1.setKeyBindings(new KeyBindings("w", "a", "d", "r"));
        PLAYER_1.addCollisionListener(new Collisions(this, PLAYER_1));

        // Player 2
        PLAYER_2 = new Player(this, 2, new Skeleton(), startPos2);
        PLAYER_2.setKeyBindings(new KeyBindings());
        PLAYER_2.addCollisionListener(new Collisions(this, PLAYER_2));
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(String filename) {
        this.background = new ImageIcon(filename).getImage();
    }

    public Player getPlayer1() {
        return PLAYER_1;
    }

    public Player getPlayer2() {
        return PLAYER_2;
    }

    public Barrier getDeathBarrier() {
        return deathBarrier;
    }

    public void setDeathBarrier(Barrier deathBarrier) {
        this.deathBarrier = deathBarrier;
        this.deathBarrier.addCollisionListener(new FallToDeath(this));
    }
}