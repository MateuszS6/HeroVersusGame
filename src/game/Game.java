package game;

import arenas.Forest;
import arenas.Royal;
import arenas.Void;
import city.cs.engine.DebugViewer;
import player.Controller;

import javax.swing.*;

/** Main game entry point. */
public class Game {
    private BattleArena arena;
    private GameView view;
    public static final float GRID_RES = 1;

    /** Initialise a new game. */
    public Game() {
        arena = new Forest(); // Game world

        view = new GameView(arena, 800, 600); // Game view

        final JFrame frame = new JFrame("HeroVersus: Battle Arena");
        frame.add(view); // Add the game view to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack(); // Resize the frame to fit world view
        frame.setVisible(true);

        // Debug tools
//        view.setGridResolution(GRID_RES);
//        new DebugViewer(arena, view.getWidth(), view.getHeight());

        arena.start();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}