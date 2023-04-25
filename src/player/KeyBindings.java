package player;

import java.awt.event.KeyEvent;

public class KeyBindings {
    final int jumpKey;
    final int leftKey;
    final int rightKey;
    final int attackKey;

    public KeyBindings(int jump, int left, int right, int attack) {
        jumpKey = jump;
        leftKey = left;
        rightKey = right;
        attackKey = attack;
    }

    public KeyBindings() {
        this(KeyEvent.VK_UP, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_PERIOD);
    }
}
