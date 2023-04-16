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
    private final Player PLAYER_1;
    private final Player PLAYER_2;
    private final Vec2 START_POS_1;
    private final Vec2 START_POS_2;
    private Barrier deathBarrier;

    /** Initialise a game world. */
    public BattleArena(Vec2 startPos1, Vec2 startPos2) {
        // World borders
        Barrier left = new Barrier(this, 0.5f, 20, -20.5f, 0);
        Barrier right = new Barrier(this, 0.5f, 20, 20.5f, 0);
        // TODO: Walk off screen teleports to other side

        // Player starting positions
        START_POS_1 = startPos1;
        START_POS_2 = startPos2;

        // Player 1
        PLAYER_1 = new Player(this, new Knight(), true);
        PLAYER_1.setKeyBindings(new KeyBindings("w", "a", "d", "r"));
        PLAYER_1.setPosition(START_POS_1);
        PLAYER_1.addCollisionListener(new Collisions(this, PLAYER_1));

        // Player 2
        PLAYER_2 = new Player(this, new Skeleton(), false);
        PLAYER_2.setKeyBindings(new KeyBindings());
        PLAYER_2.setPosition(START_POS_2);
        PLAYER_2.addCollisionListener(new Collisions(this, PLAYER_2));
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

    public void respawnPlayer(Player player) {
        if (player.getLives() < 2) {
            player.setLives(0);
            player.setLives(0);
            player.destroy();
        } else if (player.getHealth() < 1) {
            if (player == PLAYER_1) {
                player.setFacingRight(true);
                player.setPosition(START_POS_1);
            } else if (player == PLAYER_2) {
                player.setFacingRight(false);
                player.setPosition(START_POS_2);
            }
            player.setHealth(player.getMaxHealth());
            player.decrementLives();
        }
    }
}