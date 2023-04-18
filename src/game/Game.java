package game;

import arenas.Classic;
import city.cs.engine.DebugViewer;
import player.Controller;

import javax.swing.*;

/** Main game entry point. */
public class Game {
    private BattleArena arena;
    private GameView view;

    /** Initialise a new game. */
    public Game() {
        arena = new Classic(); // Game world

        view = new GameView(arena, 800, 600); // Game view
//        view.setGridResolution(1);

        view.addKeyListener(new Controller(arena.getPlayer1())); // Player 1 controller
        view.addKeyListener(new Controller(arena.getPlayer2())); // Player 2 controller

        final JFrame frame = new JFrame("HeroVersus: Battle Arena");
        frame.add(view); // Add the game view to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack(); // Resize the frame to fit world view
        frame.setVisible(true);

//        JFrame debugView = new DebugViewer(arena, view.getWidth(), view.getHeight());

        arena.start();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
}