package menu;

import game.Game;

import javax.swing.*;
import java.awt.*;

public class TitleScreen {
    private final Game game;
    private JPanel mainPanel;
    private JButton playButton;
    private JButton controlsButton;
    private JButton quitButton;

    public TitleScreen(Game g) {
        game = g;
        mainPanel.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        playButton.addActionListener(e -> game.switchPanel(new PlayScreen(game).getMainPanel()));
        controlsButton.addActionListener(e -> game.switchPanel(new ControlsPage(game).getMainPanel()));
        quitButton.addActionListener(e -> System.exit(0));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
