package game;

import city.cs.engine.UserView;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

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
        if (arena.getBgImage() == null) {
            g.setColor(arena.getBgColour());
            g.fillRect(0, 0, getWidth(), getHeight());
        } else g.drawImage(arena.getBgImage(), 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        Color label = new Color(255, 255, 255, 165);
        g.setColor(label);
        g.setFont(new Font("Bahnschrift", Font.BOLD, 15));

        int w = 120;
        int h = 65;
        int x = 10; // (getWidth() / 2) - (w + 5);
        int y = 10;

        // Player 1 HUD
        player1.drawHUD(g, w, h, x, y);
        Point2D.Float p1 = worldToView(player1.getPosition());
        if (player1.getRespawns() > 0) g.drawString("Player 1", p1.x - 30, p1.y - 5);

        // Player 2 HUD
        player2.drawHUD(g, w, h, getWidth() - (w + x), y);
        Point2D.Float p2 = worldToView(player2.getPosition());
        if (player2.getRespawns() > 0) g.drawString("Player 2", p2.x - 30, p2.y - 45);
    }
}