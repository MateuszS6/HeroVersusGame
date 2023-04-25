package player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    private final Player player;
    private int key;

    /** Initialise the game controller. */
    public Controller(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        if (key == player.getKeyBindings().jumpKey) player.jump();
        if (key == player.getKeyBindings().leftKey) player.run(-1);
        if (key == player.getKeyBindings().rightKey) player.run(1);
        if (key == player.getKeyBindings().attackKey) player.attack();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = e.getKeyCode();
        if (key == player.getKeyBindings().leftKey ||
                key == player.getKeyBindings().rightKey) player.idle();
    }
}