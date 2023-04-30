package game;

import javax.swing.*;

public class TitleScreen {
    private JPanel mainPanel;
    private JButton play;
    private JButton quit;

    public TitleScreen() {
        play.addActionListener(e -> System.out.println("play"));
        quit.addActionListener(e -> System.out.println("quit"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
