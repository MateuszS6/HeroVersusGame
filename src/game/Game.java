package game;

import arenas.Forest;

import javax.swing.*;

/** Main game entry point. */
public final class Game {
    private final JFrame window;
    private JPanel currentScreen;
    private BattleArena arena;
    private GameView view;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    /** Initialise a new game. */
    public Game() {
        // TODO: 30/04/2023 Main menu book-style as imagined

        window = new JFrame("HeroVersus: Battle Arena");

        currentScreen = new TitleScreen(this).getMainPanel();
        // This JPanel screen is resized instead of the JFrame window,
        // due to the window size including the borders and top bar
        // - meaning it is larger (816x639) than the intended GameView size (800x600),
        // so that the GameView sized correctly when it is created
        window.add(currentScreen); // Add the component to the window
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

    private void switchPanel(JPanel remove, JPanel add) {
        window.remove(remove);
        window.add(add);
        window.pack();
    }

    public void play() {
        arena = new Forest(this); // Game world

        view = new GameView(arena, WIDTH, HEIGHT); // Game view

        switchPanel(currentScreen, view);

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