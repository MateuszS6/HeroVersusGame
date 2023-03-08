package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

/** Game view class. */
public class GameView extends UserView {
    private Image background;

    /** Initialise the game view. */
    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("assets/background/arena_with_stage.jpg").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
}