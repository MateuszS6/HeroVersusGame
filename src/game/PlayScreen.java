package game;

import arenas.Forest;
import arenas.Royal;
import arenas.Void;

import javax.swing.*;
import java.awt.*;

public class PlayScreen {
    private final Game game;
    private JPanel mainPanel;
    private JComboBox<String> comboBox;
    private Arenas selection;
    private JButton fightButton;
    private JButton backButton;

    public PlayScreen(Game g) {
        game = g;
        mainPanel.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        comboBox.addActionListener(e -> {
            selection = switch (comboBox.getSelectedIndex()) {
                case 1 -> Arenas.ROYAL_ARENA;
                case 2 -> Arenas.WILD_FOREST;
                case 3 -> Arenas.THE_VOID;
                default -> null;
            };
        });
        fightButton.addActionListener(e -> {
            if (selection != null) game.goToArena(selection);
        });
        backButton.addActionListener(e -> game.switchPanel(getMainPanel(), new TitleScreen(game).getMainPanel()));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}