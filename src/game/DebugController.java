package game;

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
    private boolean gridToggle = false;
    private boolean outlineToggle = false;

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
        if (key == G) {
            gridToggle = !gridToggle;
            if (gridToggle) view.setGridResolution(GRID);
            else view.setGridResolution(0);
        }
        if (key == H) view.runDebugViewer();
        if (key == T) {
            outlineToggle = !outlineToggle;
            arena.getPlayer1().setAlwaysOutline(outlineToggle);
            arena.getPlayer2().setAlwaysOutline(outlineToggle);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = e.getKeyCode();
    }
}
