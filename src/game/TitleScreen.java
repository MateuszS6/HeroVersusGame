package game;

import javax.swing.*;
import java.awt.*;

public class TitleScreen {
    private final Game game;
    private JPanel mainPanel;
    private JButton play;
    private JButton quit;

    public TitleScreen(Game g) {
        game = g;
        mainPanel.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        play.addActionListener(e -> game.play());
        quit.addActionListener(e -> System.exit(0));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
