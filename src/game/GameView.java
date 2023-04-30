package game;

import city.cs.engine.UserView;
import player.Controller;
import player.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

/** Game view class. */
public class GameView extends UserView {
    private final BattleArena arena;
    private final Player player1;
    private final Player player2;

    /** Initialise the game view. */
    public GameView(BattleArena w, int width, int height) {
        super(w, width, height);

        arena = w;
        player1 = arena.getPlayer1();
        player2 = arena.getPlayer2();

        addKeyListener(new Controller(player1)); // Player 1 controller
        addKeyListener(new Controller(player2)); // Player 2 controller

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
        Point2D.Float p1 = worldToView(player1.getPosition());
        Point2D.Float p2 = worldToView(player2.getPosition());

        arena.drawHUD(g, getWidth(), getHeight(), p1, p2);
    }
}