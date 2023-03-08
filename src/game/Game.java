package game;

import city.cs.engine.DebugViewer;

import javax.swing.*;

/** Main game entry point. */
public class Game {
    /** Initialise a new game. */
    public Game() {
        // Empty game world
        GameWorld arena = new GameWorld();
        // Game view
        GameView view = new GameView(arena, 800, 600);
        view.setGridResolution(1);

        // Player controllers and keybindings
        PlayerController controller1 = new PlayerController(arena.getPlayer1());
        PlayerController controller2 = new PlayerController(arena.getPlayer2());
        view.addKeyListener(controller1);
        view.addKeyListener(controller2);
        arena.getPlayer1().setKeybindings(new Keybindings("w", "a", "d"));
        arena.getPlayer2().setKeybindings(new Keybindings());

        // Java window with game view
        final JFrame frame = new JFrame("HeroVersus");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        // Size frame to fit world view
        frame.pack();
        frame.setVisible(true);

        JFrame debugView = new DebugViewer(arena, 800, 600);

        arena.start();
        view.requestFocus();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}