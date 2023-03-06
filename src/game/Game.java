package game;

import javax.swing.*;

/** The main game entry point. */
public class Game {
    /** Initialise a new game. */
    public Game() {
        // Empty game world
        GameWorld arena = new GameWorld();
        // Game view
        GameView view = new GameView(arena, 800, 600);
        view.setGridResolution(1);

        // Character controller
        CharacterController controller = new CharacterController(arena.getPlayer1(), 5, 5);
        view.addKeyListener(controller);

        // Java window with game view
        final JFrame frame = new JFrame("HeroVersus");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        // Size frame to fit world view
        frame.pack();
        frame.setVisible(true);

        // JFrame debugView = new DebugViewer(world, 500, 500);

        arena.start();
        view.requestFocus();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}