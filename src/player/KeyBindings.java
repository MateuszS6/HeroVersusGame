package player;

public class KeyBindings {
    String jumpKey;
    String leftKey;
    String rightKey;
    String attackKey;

    public KeyBindings() {
        jumpKey = "up";
        leftKey = "left";
        rightKey = "right";
        attackKey = ".";
    }

    public KeyBindings(String jump, String left, String right, String attack) {
        jumpKey = jump;
        leftKey = left;
        rightKey = right;
        attackKey = attack;
    }
}
