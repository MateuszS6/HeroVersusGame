package game;

import arenas.Forest;
import arenas.Royal;
import arenas.Void;
import city.cs.engine.SoundClip;
import menu.PlayScreen;
import menu.TitleScreen;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/** Main game entry point. */
public final class Game {
    public static final String MENU_MUSIC = "tension_mode.mp3";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private final JFrame window;
    private JPanel currentScreen;
    private SoundClip soundtrack;
    private BattleArena arena;
    private GameView view;

    /** Initialise a new game. */
    public Game() {
        // TODO: 30/04/2023 Main menu book-style as imagined

        window = new JFrame("HeroVersus");

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

    public void setSoundtrack(String fileName) {
        try {
            if (soundtrack != null) soundtrack.stop();
            soundtrack = new SoundClip("assets/sound/music/" + fileName);
            soundtrack.setVolume(0.3);
            soundtrack.loop();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void playSound(String fileName) {
        try {
            new SoundClip("assets/sound/" + fileName).play();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchPanel(JPanel to) {
//        if (currentScreen != view) playSound(null);
        window.remove(currentScreen);
        window.add(to);
        window.pack();
        currentScreen = to;
    }

    // TODO: 29/04/2023 Winning player of final round is ULTIMATE CHAMPION
    public void goToArena(Arenas a) {
        arena = getArena(a);
        view = new GameView(arena, WIDTH, HEIGHT); // Game view
        switchPanel(view);
        arena.start();
    }

    public BattleArena getArena(Arenas a) {
        return switch (a) {
            case ROYAL_ARENA -> new Royal(this);
            case WILD_FOREST -> new Forest(this);
            case THE_VOID -> new Void(this);
        }; // Game world
    }

    public void restart() {
    }
}