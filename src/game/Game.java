package game;

import arenas.Royal;
import city.cs.engine.DebugViewer;

import javax.swing.*;
import java.awt.*;

/** Main game entry point. */
public final class Game {
    private final JFrame window;
    public static final int WIDTH = 816;
    public static final int HEIGHT = 638;
    private JPanel currentScreen;
    private BattleArena arena;
    private GameView view;
    public static final float GRID = 1;
    private DebugViewer debugViewer;

    /** Initialise a new game. */
    public Game() {
        // TODO: 30/04/2023 Main menu book-style as imagined

        window = new JFrame("HeroVersus: Battle Arena");

        currentScreen = new TitleScreen(this).getMainPanel();
        window.add(currentScreen); // Add the component to the window
        window.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // Set the correct window size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationByPlatform(true);
        window.setResizable(false);
        window.setVisible(true);
        window.pack(); // Resize the window to fit the preferred size
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }

    private void rebuildWindow(Component remove, Component add) {
        window.remove(remove);
        window.add(add);
        window.pack();
    }

    public boolean debugGrid(boolean on, int res) {
        if (on) view.setGridResolution(res);
        else view.setGridResolution(0);
        return on;
    }

    public void runDebugViewer() {
        if (debugViewer == null) debugViewer = new DebugViewer(arena, view.getWidth(), view.getHeight());
    }

    public void play() {
        arena = new Royal(); // Game world
        arena.setGame(this);

        view = new GameView(arena, 800, 600); // Game view
        view.addKeyListener(new DebugController(this, 2));

        rebuildWindow(currentScreen, view);

        arena.start();
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