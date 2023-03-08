package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class PlayerController implements KeyListener {
    private final Player player;
    private float runningSpeed;
    private float jumpingSpeed;
    private static Map<String, Integer> keyMap = new HashMap<>();

    /** Initialise the game controller. */
    public PlayerController(Player player) {
        this.player = player;
        runningSpeed = player.getCharacter().getRunningSpeed();
        jumpingSpeed = player.getCharacter().getJumpingSpeed();
        keyMap.put("w", KeyEvent.VK_W);
        keyMap.put("a", KeyEvent.VK_A);
        keyMap.put("d", KeyEvent.VK_D);
        keyMap.put("up", KeyEvent.VK_UP);
        keyMap.put("left", KeyEvent.VK_LEFT);
        keyMap.put("right", KeyEvent.VK_RIGHT);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == keyMap.get(player.getKeybindings().jumpKey)) player.jump(jumpingSpeed);
        if (key == keyMap.get(player.getKeybindings().leftKey)) player.startWalking(-runningSpeed);
        if (key == keyMap.get(player.getKeybindings().rightKey)) player.startWalking(runningSpeed);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == keyMap.get(player.getKeybindings().leftKey)) player.stopWalking();
        if (key == keyMap.get(player.getKeybindings().rightKey)) player.stopWalking();
    }
}