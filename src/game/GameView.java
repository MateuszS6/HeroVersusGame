package game;

import city.cs.engine.BoxShape;
import city.cs.engine.CircleShape;
import city.cs.engine.UserView;
import player.Player;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/** Game view class. */
public class GameView extends UserView {
    private BattleArena arena;
    private Player player1;
    private Player player2;

    /** Initialise the game view. */
    public GameView(BattleArena arena, int width, int height) {
        super(arena, width, height);

        this.arena = arena;
        player1 = this.arena.getPlayer1();
        player2 = this.arena.getPlayer2();

        // View focus
        addMouseListener(new GiveFocus(this));
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(arena.getBackground(), 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Bahnschrift", Font.BOLD, 25));

        // Player 1 HUD
        g.drawString("Player 1", 10, 25);
        player1.drawHealthBar(g, 10, 40, 100, 20);

        // Player 2 HUD
        g.drawString("Player 2", getWidth() - 110, 25);
        player2.drawHealthBar(g, getWidth() - 110, 40, 100, 20);

//        g.drawString("Health: " + arena.getPlayer2().getHealth(), this.getWidth() - 90, 50);
//        g.drawString("Lives: " + arena.getPlayer2().getLives(), this.getWidth() - 70, 70);
    }
}