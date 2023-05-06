package game;

import arenas.BattleArena;
import city.cs.engine.DebugViewer;
import city.cs.engine.UserView;
import player.PlayerController;

import java.awt.*;
import java.awt.geom.Point2D;

/** Game view class. */
public class GameView extends UserView {
    public static final float GRID = 1;
    private final BattleArena arena;
    private DebugViewer debugViewer;

    /** Initialise the game view. */
    public GameView(BattleArena w, int width, int height) {
        super(w, width, height);
        arena = w;

        addKeyListener(new PlayerController(arena.getPlayer1())); // Player 1 controller
        addKeyListener(new PlayerController(arena.getPlayer2())); // Player 2 controller

        addMouseListener(new GiveFocus(this)); // View focus
        addKeyListener(new GameController(this, arena, GRID)); // Debug controller
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
        Point2D.Float p1 = worldToView(arena.getPlayer1().getPosition());
        Point2D.Float p2 = worldToView(arena.getPlayer2().getPosition());

        arena.drawHUD(g, getWidth(), getHeight(), p1, p2);
    }

    public void runDebugViewer() {
        if (debugViewer == null) debugViewer = new DebugViewer(arena, getWidth(), getHeight());
    }

    // TODO: 04/05/2023 Update key listeners and stuff as if it were creating a whole new view
}