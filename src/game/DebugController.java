package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DebugController implements KeyListener {
    private final Game game;
    private int key;
    private boolean gToggle = false;
    private final int GRID;
    private final int G = KeyEvent.VK_G;
    private final int H = KeyEvent.VK_H;

    public DebugController(Game game, int grid) {
        this.game = game;
        GRID = grid;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        if (key == G) gToggle = game.debugGrid(!gToggle, GRID);
        if (key == H) game.runDebugViewer();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = e.getKeyCode();
    }
}
