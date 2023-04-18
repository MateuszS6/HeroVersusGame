package game;

import city.cs.engine.BoxShape;
import city.cs.engine.CircleShape;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;
import player.Player;

import java.awt.*;
import java.awt.geom.Point2D;
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
        Color backBlack = new Color(0, 0, 0, 165);
        g.setColor(backBlack);
        g.setFont(new Font("Bahnschrift", Font.BOLD, 17));

        int x = 10;
        int y = getHeight() - 75;
        int w = 120;
        int h = 65;

        // Player 1 HUD
        player1.drawHUD(g, x, y, w, h);
        Point2D.Float p1 = worldToView(player1.getPosition());
        if (player1.getLives() > 0) g.drawString("Player 1", p1.x - 30, p1.y - 5);

        // Player 2 HUD
        player2.drawHUD(g, getWidth() - (w + x), y, w, h);
        Point2D.Float p2 = worldToView(player2.getPosition());
        if (player2.getLives() > 0) g.drawString("Player 2", p2.x - 30, p2.y - 45);
    }
}