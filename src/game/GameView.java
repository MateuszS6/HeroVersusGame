package game;

import city.cs.engine.UserView;
import player.Player;

import javax.swing.*;
import java.awt.*;

/** Game view class. */
public class GameView extends UserView {
    private Image background;
    private Player player1;
    private Player player2;

    /** Initialise the game view. */
    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("assets/background/arena_with_stage.jpg").getImage();

        player1 = world.getPlayer1();
        player2 = world.getPlayer2();

        // View focus
        addMouseListener(new GiveFocus(this));
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
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
        g.drawString("Health: " + player1.getHealth(), 10, 50);
        g.drawString("Health: " + player2.getHealth(), this.getWidth() - 90, 50);
        g.drawString("Lives: " + ((int) player1.getLives()), 10, 70);
        g.drawString("Lives: " + ((int) player2.getLives()), this.getWidth() - 70, 70);
    }
}