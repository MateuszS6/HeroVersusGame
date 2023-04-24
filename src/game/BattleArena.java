package game;

import characters.Knight;
import characters.Skeleton;
import city.cs.engine.BoxShape;
import city.cs.engine.CollisionListener;
import city.cs.engine.GhostlyFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;
import player.Collisions;
import player.KeyBindings;
import player.Player;
import world.Barrier;
import world.FallToDeath;
import world.Tile;

import javax.swing.*;
import java.awt.*;

public abstract class BattleArena extends World {
    // TODO: 1 life, best of 3, winning player chooses next arena to play in
    // TODO: Add PRACTICE ARENA with grey tiles - unlimited respawns, advances to arenas on completion OR on SKIP button
    // TODO: Desert arena, minimalistic/paper arena
    private Color bgColour;
    private Image bgImage;
    private final Player
            player1,
            player2;
    private final Barrier
            left,
            right;
    private Barrier deathBarrier;

    /** Initialise a game world. */
    public BattleArena(float x1, float x2, float y1, float y2) {
        // World borders
        left = new Barrier(this, 0.5f, 20, -21, 0);
        left.addCollisionListener(new TeleportToOtherSide(this));
        right = new Barrier(this, 0.5f, 20, 21, 0);
        right.addCollisionListener(new TeleportToOtherSide(this));

        // Player 1
        player1 = new Player(this, 1, new Knight(), new Vec2(x1, y1));
        player1.setKeyBindings(new KeyBindings("w", "a", "d", "r"));

        // Player 2
        player2 = new Player(this, 2, new Skeleton(), new Vec2(x2, y2));
        player2.setKeyBindings(new KeyBindings());

        // Fill the world with tiles
        populate();
    }

    public Color getBgColour() {
        return bgColour;
    }

    public Image getBgImage() {
        return bgImage;
    }

    public void setBackground(Color color) {
        bgColour = color;
    }

    public void setBackground(String filename) {
        bgImage = new ImageIcon(filename).getImage();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Barrier getOtherSide(Barrier barrier) {
        Barrier other = null;
        if (barrier == left) other = right;
        else if (barrier == right) other = left;
        return other;
    }

    public Barrier getDeathBarrier() {
        return deathBarrier;
    }

    public void setDeathBarrier(World world, float y) {
        deathBarrier = new Barrier(world, right.getPosition().x, 0.5f, 0, y);
        deathBarrier.addCollisionListener(new FallToDeath(this));
    }

    public void addTile(String type, float x, float y) {
        new Tile(this, type, x, y);
    }

    public abstract void populate();
}