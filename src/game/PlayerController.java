package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private final Player player;
    private float runningSpeed;
    private float jumpingSpeed;

    /** Initialise the game controller. */
    public PlayerController(Player player) {
        this.player = player;
        runningSpeed = player.getCharacter().getRunningSpeed();
        jumpingSpeed = player.getCharacter().getJumpingSpeed();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) player.startWalking(-runningSpeed);
        if (key == KeyEvent.VK_RIGHT) player.startWalking(runningSpeed);
        if (key == KeyEvent.VK_UP) player.jump(jumpingSpeed);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) player.stopWalking();
        if (key == KeyEvent.VK_RIGHT) player.stopWalking();
    }
}