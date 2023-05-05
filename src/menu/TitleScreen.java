package menu;

import game.Game;

import javax.swing.*;
import java.awt.*;

public class TitleScreen {
    private final Game game;
    private JPanel mainPanel;
    private JButton playButton;
    private JButton quitButton;

    public TitleScreen(Game g) {
        game = g;
        mainPanel.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        playButton.addActionListener(e -> game.switchPanel(new PlayScreen(game).getMainPanel()));
        quitButton.addActionListener(e -> System.exit(0));
        game.setSoundtrack(Game.MENU_MUSIC);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
