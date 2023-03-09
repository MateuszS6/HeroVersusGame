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
        // view.setGridResolution(1);

        // View focus
        GiveFocus viewFocus = new GiveFocus(view);
        view.addMouseListener(viewFocus);

        // Player controllers and keybindings
        PlayerController controller1 = new PlayerController(arena.getPlayer1());
        PlayerController controller2 = new PlayerController(arena.getPlayer2());
        view.addKeyListener(controller1);
        view.addKeyListener(controller2);
        arena.getPlayer1().setKeyBindings(new KeyBindings("w", "a", "d", "r"));
        arena.getPlayer2().setKeyBindings(new KeyBindings());

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
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}