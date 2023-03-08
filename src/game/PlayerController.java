package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class PlayerController implements KeyListener {
    private Player player;
    private float runningSpeed;
    private float jumpingSpeed;
    private static final Map<String, Integer> KEY_MAP = new HashMap<>();

    /** Initialise the game controller. */
    public PlayerController(Player player) {
        this.player = player;
        runningSpeed = player.getCharacter().getRunningSpeed();
        jumpingSpeed = player.getCharacter().getJumpingSpeed();
    }

    static {
        KEY_MAP.put("w", KeyEvent.VK_W);
        KEY_MAP.put("a", KeyEvent.VK_A);
        KEY_MAP.put("d", KeyEvent.VK_D);
        KEY_MAP.put("up", KeyEvent.VK_UP);
        KEY_MAP.put("left", KeyEvent.VK_LEFT);
        KEY_MAP.put("right", KeyEvent.VK_RIGHT);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KEY_MAP.get(player.getKeybindings().jumpKey))
            player.jump(jumpingSpeed);
        else if (key == KEY_MAP.get(player.getKeybindings().leftKey))
            player.startWalking(-runningSpeed);
        else if (key == KEY_MAP.get(player.getKeybindings().rightKey))
            player.startWalking(runningSpeed);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KEY_MAP.get(player.getKeybindings().leftKey))
            player.stopWalking();
        else if (key == KEY_MAP.get(player.getKeybindings().rightKey))
            player.stopWalking();
    }
}