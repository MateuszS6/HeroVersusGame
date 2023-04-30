package game;

import arenas.Royal;
import city.cs.engine.DebugViewer;

import javax.swing.*;

/** Main game entry point. */
public final class Game {
    private JFrame window;
    private BattleArena arena;
    private GameView view;
    public static final float GRID = 1;
    private DebugViewer debugViewer;

    /** Initialise a new game. */
    public Game() {
        // TODO: 30/04/2023 Main menu book-style as imagined

        window = new JFrame("HeroVersus: Battle Arena");

        // TODO: 01/05/2023 Start with title screen!

        arena = new Royal(); // Game world
        arena.setGame(this);

        view = new GameView(arena, 800, 600); // Game view
        view.addKeyListener(new DebugController(this, 2));

        buildWindow(); // Create and build the JFrame

        arena.start();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }

    private void buildWindow() {
        window.add(view); // Add the game view to the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationByPlatform(true);
        window.setResizable(false);
        window.pack(); // Resize the window to fit world view
        window.setVisible(true);
    }

    public void debugGrid(boolean on, int res) {
        if (on) view.setGridResolution(res);
        else view.setGridResolution(0);
    }

    public void runDebugViewer() {
        if (debugViewer == null) debugViewer = new DebugViewer(arena, view.getWidth(), view.getHeight());
    }

    // TODO: 29/04/2023 Winning player of final round is ULTIMATE CHAMPION
    public void goToArena(BattleArena w) {
        arena.stop();
        arena = w;
        view.setWorld(arena);
        // TODO: 29/04/2023 Update player controllers
        arena.start();
    }

    public void restart() {
    }

    public void backToTitleScreen() {
    }
}