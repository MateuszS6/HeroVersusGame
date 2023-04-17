package game;

import city.cs.engine.UserView;

import java.awt.*;

/** Game view class. */
public class GameView extends UserView {
    private BattleArena arena;

    /** Initialise the game view. */
    public GameView(BattleArena arena, int width, int height) {
        super(arena, width, height);

        this.arena = arena;

        // View focus
        addMouseListener(new GiveFocus(this));
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(arena.getBackground(), 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        String fontName = "Bahnschrift";
        g.setColor(Color.BLACK);
        // g.setStroke(new BasicStroke(10));

        g.setFont(new Font(fontName, Font.BOLD, 30));
        g.drawString("PLAYER 1", 10, 30);
        g.drawString("PLAYER 2", this.getWidth() - 150, 30);

        g.setFont(new Font(fontName, Font.BOLD, 15));
        g.drawString("Health: " + arena.getPlayer1().getHealth(), 10, 50);
        g.drawString("Health: " + arena.getPlayer2().getHealth(), this.getWidth() - 90, 50);
        g.drawString("Lives: " + arena.getPlayer1().getLives(), 10, 70);
        g.drawString("Lives: " + arena.getPlayer2().getLives(), this.getWidth() - 70, 70);
    }
}