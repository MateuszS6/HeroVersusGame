package game;

import city.cs.engine.DebugViewer;

import javax.swing.*;

/** Main game entry point. */
public class Game {
    /** Initialise a new game. */
    public Game() {
        GameWorld arena = new GameWorld();  // Empty game world

        GameView view = new GameView(arena, 800, 600);  // Game view
        // view.setGridResolution(1);

        // Player controllers and keybindings
        view.addKeyListener(new PlayerController(arena.getPlayer1()));
        view.addKeyListener(new PlayerController(arena.getPlayer2()));

        // Player step listener
        // arena.addStepListener(new TestStepListener(view, arena.getPlayer1()));

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