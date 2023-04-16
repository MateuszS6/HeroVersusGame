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

public abstract class BattleArena extends World {
    private Player player1;
    private Player player2;
    private Vec2 startPos1;
    private Vec2 startPos2;
    private Barrier deathBarrier;

    /** Initialise a game world. */
    public BattleArena(Vec2 startPos1, Vec2 startPos2) {
        // World borders
        Barrier left = new Barrier(this, 0.5f, 20, -20.5f, 0);
        Barrier right = new Barrier(this, 0.5f, 20, 20.5f, 0);
        Barrier ceiling = new Barrier(this, 20, 0.5f, 0, 20);
        deathBarrier = new Barrier(this, 20, 0.5f, 0, -20);
        deathBarrier.addCollisionListener(new FallToDeath(this));

        // Player positions
        this.startPos1 = startPos1;
        this.startPos2 = startPos2;

        // Player 1
        player1 = new Player(this, new Knight(), true);
        player1.setKeyBindings(new KeyBindings("w", "a", "d", "r"));
        player1.setPosition(startPos1);
        player1.addCollisionListener(new Collisions(this, player1));

        // Player 2
        player2 = new Player(this, new Skeleton(), false);
        player2.setKeyBindings(new KeyBindings());
        player2.setPosition(startPos2);
        player2.addCollisionListener(new Collisions(this, player2));
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

    public void respawnPlayer(Player player) {
        if (player.getLives() < 2) {
            player.setLives(0);
            player.setLives(0);
            player.destroy();
        } else if (player.getHealth() < 1) {
            if (player == player1) {
                player.setFacingRight(true);
                player.setPosition(startPos1);
            } else if (player == player2) {
                player.setFacingRight(false);
                player.setPosition(startPos2);
            }
            player.setHealth(player.getMaxHealth());
            player.decrementLives();
            System.out.println(player.getLives());
        }
    }
}