package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class PlayerController implements KeyListener {
    private Player player;
    private static final Map<String, Integer> KEY_MAP = new HashMap<>();
    private BodyImage idleLeftImg;
    private BodyImage idleRightImg;
    private BodyImage jumpingLeftImg;
    private BodyImage jumpingRightImg;
    private BodyImage runningLeftImg;
    private BodyImage runningRightImg;
    private BodyImage attackLeftImg;
    private BodyImage attackRightImg;
    private float runningSpeed;
    private float jumpingSpeed;

    /** Initialise the game controller. */
    public PlayerController(Player player) {
        this.player = player;

        idleLeftImg = player.getCharacter().getIdleLeftImage();
        idleRightImg = player.getCharacter().getIdleRightImage();
        jumpingLeftImg = player.getCharacter().getJumpingLeftImage();
        jumpingRightImg = player.getCharacter().getJumpingRightImage();
        runningLeftImg = player.getCharacter().getRunningLeftImage();
        runningRightImg = player.getCharacter().getRunningRightImage();
        attackLeftImg = player.getCharacter().getAttackLeftImage();
        attackRightImg = player.getCharacter().getAttackRightImage();

        runningSpeed = player.getCharacter().getRunningSpeed();
        jumpingSpeed = player.getCharacter().getJumpingSpeed();
    }

    static {
        // Player 1
        KEY_MAP.put("w", KeyEvent.VK_W);
        KEY_MAP.put("a", KeyEvent.VK_A);
        KEY_MAP.put("d", KeyEvent.VK_D);
        KEY_MAP.put("r", KeyEvent.VK_R);
        KEY_MAP.put("lShift", KeyEvent.KEY_LOCATION_LEFT);

        // Player 2
        KEY_MAP.put("up", KeyEvent.VK_UP);
        KEY_MAP.put("left", KeyEvent.VK_LEFT);
        KEY_MAP.put("right", KeyEvent.VK_RIGHT);
        KEY_MAP.put("#", KeyEvent.VK_NUMBER_SIGN);
        KEY_MAP.put("rShift", KeyEvent.KEY_LOCATION_RIGHT);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KEY_MAP.get(player.getKeyBindings().jumpKey)) {
            if (player.isFacingRight()) {
                player.removeAllImages();
                player.addImage(jumpingRightImg);
            } else {
                player.removeAllImages();
                player.addImage(jumpingLeftImg);
            }
            player.jump(jumpingSpeed);
        } else if (key == KEY_MAP.get(player.getKeyBindings().leftKey)) {
            player.setFacingRight(false);
            player.removeAllImages();
            player.addImage(runningLeftImg);
            player.startWalking(-runningSpeed);
        } else if (key == KEY_MAP.get(player.getKeyBindings().rightKey)) {
            player.setFacingRight(true);
            player.removeAllImages();
            player.addImage(runningRightImg);
            player.startWalking(runningSpeed);
        } else if (key == KEY_MAP.get(player.getKeyBindings().attackKey)) {
            if (player.isFacingRight()) {
                player.removeAllImages();
                player.addImage(attackRightImg);
            } else {
                player.removeAllImages();
                player.addImage(attackLeftImg);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KEY_MAP.get(player.getKeyBindings().jumpKey)) {
            if (player.isFacingRight()) {
                player.removeAllImages();
                player.addImage(idleRightImg);
            } else {
                player.removeAllImages();
                player.addImage(idleLeftImg);
            }
        } else if (key == KEY_MAP.get(player.getKeyBindings().leftKey)) {
            player.removeAllImages();
            player.addImage(idleLeftImg);
            player.stopWalking();
        } else if (key == KEY_MAP.get(player.getKeyBindings().rightKey)) {
            player.removeAllImages();
            player.addImage(idleRightImg);
            player.stopWalking();
        } else if (key == KEY_MAP.get(player.getKeyBindings().attackKey)) {
            if (player.isFacingRight()) {
                player.removeAllImages();
                player.addImage(idleRightImg);
            } else {
                player.removeAllImages();
                player.addImage(idleLeftImg);
            }
        }
    }
}