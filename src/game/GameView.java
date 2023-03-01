package game;

import city.cs.engine.UserView;

import javax.swing.*;

import java.awt.*;

/** Game view class. */
public class GameView extends UserView {
    private final Image background = new ImageIcon("data/university.gif").getImage();
    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
}