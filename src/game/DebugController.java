package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DebugController implements KeyListener {
    private GameView view;
    private int key;
    private boolean gToggle = false;
    private final float GRID;
    private final int G = KeyEvent.VK_G;
    private final int H = KeyEvent.VK_H;

    public DebugController(GameView v, float grid) {
        view = v;
        GRID = grid;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        if (key == G) {
            gToggle = !gToggle;
            if (gToggle) view.setGridResolution(GRID);
            else view.setGridResolution(0);
        }
        if (key == H) view.runDebugViewer();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = e.getKeyCode();
    }
}
