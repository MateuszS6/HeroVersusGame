package game;

import arenas.BattleArena;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
    private final float GRID;
    private final GameView view;
    private final BattleArena arena;
    private int key;
    private boolean debugModeOn = false;
    private boolean playerOutlineOn = false;
    private boolean gridOn = false;

    public GameController(GameView v, BattleArena w, float grid) {
        view = v;
        arena = w;
        GRID = grid;
        System.out.println("Debug mode off");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        if (debugModeOn) {
            if (key == KeyEvent.VK_T) {
                playerOutlineOn = !playerOutlineOn;
                arena.getPlayer1().setAlwaysOutline(playerOutlineOn);
                arena.getPlayer2().setAlwaysOutline(playerOutlineOn);
            }
            if (key == KeyEvent.VK_G) {
                gridOn = !gridOn;
                if (gridOn) view.setGridResolution(GRID);
                else view.setGridResolution(0);
            }
            if (key == KeyEvent.VK_H) view.runDebugViewer();
        }
        if (key == KeyEvent.VK_0) {
            debugModeOn = !debugModeOn;
            System.out.println("Debug mode " + (debugModeOn ? "on" : "off"));
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.out.println("pause");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = e.getKeyCode();
    }
}
