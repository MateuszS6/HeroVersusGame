package menu;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControlsPage {
    Game game;
    private JPanel mainPanel;
    private JButton backButton;
    private JPanel controlsPanel;
    private JButton left1;
    private JButton jump1;
    private JButton right1;
    private JButton attack1;
    private JButton left2;
    private JButton jump2;
    private JButton right2;
    private JButton attack2;

    public ControlsPage(Game g) {
        game = g;
        mainPanel.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        backButton.addActionListener(e -> game.switchPanel(new TitleScreen(game).getMainPanel()));

        KeyAdapter listener = new KeyAdapter() {
            int key;
            @Override
            public void keyPressed(KeyEvent e) {
                key = e.getKeyCode();
                System.out.println(KeyEvent.getKeyText(key));
            }
        };
        left1.addKeyListener(listener);
        jump1.addKeyListener(listener);
        right1.addKeyListener(listener);
        attack1.addKeyListener(listener);
        left2.addKeyListener(listener);
        jump2.addKeyListener(listener);
        right2.addKeyListener(listener);
        attack2.addKeyListener(listener);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
