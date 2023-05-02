package game;

import arenas.Forest;
import arenas.Royal;
import arenas.Void;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ArenaSelection {
    private final Game game;
    private JPanel mainPanel;
    private JComboBox<String> comboBox;
    private BattleArena selection;
    private JButton fightButton;
    private JButton backButton;

    public ArenaSelection(Game g) {
        game = g;
        mainPanel.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        comboBox.addActionListener(e -> {
            selection = switch (comboBox.getSelectedIndex()) {
                case 1 -> new Royal(game);
                case 2 -> new Forest(game);
                case 3 -> new Void(game);
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
