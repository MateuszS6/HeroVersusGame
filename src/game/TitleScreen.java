package game;

import javax.swing.*;

public class TitleScreen {
    private final Game game;
    private JPanel mainPanel;
    private JButton play;
    private JButton quit;

    public TitleScreen(Game g) {
        game = g;
        play.addActionListener(e -> game.play());
        quit.addActionListener(e -> System.exit(0));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
