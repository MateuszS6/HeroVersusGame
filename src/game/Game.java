package game;

import city.cs.engine.*;

import javax.swing.JFrame;

/** The main game entry point. */
public class Game {
    /** Initialise a new game. */
    public Game() {
        // Empty game world
        GameWorld world = new GameWorld();

        // Game view
        GameView view = new GameView(world, 500, 500);
        // Optional: 1-meter grid over game view
        // view.setGridResolution(1);

        // Java window with game view
        final JFrame frame = new JFrame("City Game");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        // Size frame to fit world view
        frame.pack();
        frame.setVisible(true);

        JFrame debugView = new DebugViewer(world, 500, 500);

        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}