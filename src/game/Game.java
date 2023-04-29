package game;

import arenas.Royal;
import city.cs.engine.DebugViewer;

import javax.swing.*;

/** Main game entry point. */
public final class Game {
    private BattleArena arena;
    private GameView view;
    public static final float GRID = 1;

    /** Initialise a new game. */
    public Game() {
        arena = new Royal(); // Game world

        view = new GameView(arena, 800, 600); // Game view

        buildWindow(); // Create and build the JFrame

        debugTools(false, 2, false);

        arena.start();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }

    private void buildWindow() {
        final JFrame frame = new JFrame("HeroVersus: Battle Arena");
        frame.add(view); // Add the game view to the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack(); // Resize the frame to fit world view
        frame.setVisible(true);
    }

    public void debugTools(boolean grid, int res, boolean viewer) {
        if (grid) view.setGridResolution(res);
        if (viewer) new DebugViewer(arena, view.getWidth(), view.getHeight());
    }

    // TODO: 29/04/2023 Winning player of final round is CHAMPION
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