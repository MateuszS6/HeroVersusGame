package game;

import arenas.BattleArena;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DebugController implements KeyListener {
    private final float GRID;
    private final int T = KeyEvent.VK_T;
    private final int G = KeyEvent.VK_G;
    private final int H = KeyEvent.VK_H;
    private GameView view;
    private BattleArena arena;
    private int key;
    private boolean debugModeOn = false;
    private boolean playerOutlineOn = false;
    private boolean gridOn = false;

    public DebugController(GameView v, BattleArena w, float grid) {
        view = v;
        arena = w;
        GRID = grid;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        if (debugModeOn) {
            if (key == T) {
                playerOutlineOn = !playerOutlineOn;
                arena.getPlayer1().setAlwaysOutline(playerOutlineOn);
                arena.getPlayer2().setAlwaysOutline(playerOutlineOn);
            }
            if (key == G) {
                gridOn = !gridOn;
                if (gridOn) view.setGridResolution(GRID);
                else view.setGridResolution(0);
            }
            if (key == H) view.runDebugViewer();
        }
        if (key == KeyEvent.VK_0) {
            debugModeOn = !debugModeOn;
            System.out.println("Debug mode " + (debugModeOn ? "on" : "off"));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = e.getKeyCode();
    }
}
