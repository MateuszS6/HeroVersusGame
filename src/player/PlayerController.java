package player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class PlayerController implements KeyListener {
    private Player player;
    private static final Map<String, Integer> KEY_MAP = new HashMap<>();

    /** Initialise the game controller. */
    public PlayerController(Player player) {
        this.player = player;
    }

    static {
        // Player 1 keybindings
        KEY_MAP.put("w", KeyEvent.VK_W);
        KEY_MAP.put("a", KeyEvent.VK_A);
        KEY_MAP.put("d", KeyEvent.VK_D);
        KEY_MAP.put("r", KeyEvent.VK_R);

        // Player 2 keybindings
        KEY_MAP.put("up", KeyEvent.VK_UP);
        KEY_MAP.put("left", KeyEvent.VK_LEFT);
        KEY_MAP.put("right", KeyEvent.VK_RIGHT);
        KEY_MAP.put(".", KeyEvent.VK_PERIOD);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        player.setMidAir(player.getLinearVelocity().y != 0);
        if (key == KEY_MAP.get(player.getKeyBindings().jumpKey)) player.jump();
        if (key == KEY_MAP.get(player.getKeyBindings().leftKey)) player.moveLeft();
        if (key == KEY_MAP.get(player.getKeyBindings().rightKey)) player.moveRight();
        if (key == KEY_MAP.get(player.getKeyBindings().attackKey)) player.attack();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        player.setMidAir(player.getLinearVelocity().y != 0);
        if (key == KEY_MAP.get(player.getKeyBindings().leftKey)) player.idle();
        if (key == KEY_MAP.get(player.getKeyBindings().rightKey)) player.idle();
    }
}