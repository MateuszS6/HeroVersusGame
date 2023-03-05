package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** Game controller class. */
public class CharacterController implements KeyListener {
    private final Player player;
    private final float RUN_SPEED;
    private final float JUMP_SPEED;

    /** Initialise the game controller. */
    public CharacterController(Player player, float runSpeed, float jumpSpeed) {
        this.player = player;
        RUN_SPEED = runSpeed;
        JUMP_SPEED = jumpSpeed;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) player.startWalking(-RUN_SPEED);
        if (key == KeyEvent.VK_RIGHT) player.startWalking(RUN_SPEED);
        if (key == KeyEvent.VK_UP) player.jump(JUMP_SPEED);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) player.stopWalking();
        if (key == KeyEvent.VK_RIGHT) player.stopWalking();
    }
}