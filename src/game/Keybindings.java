package game;

public class Keybindings {
    String jumpKey;
    String leftKey;
    String rightKey;
    String attack;

    public Keybindings() {
        jumpKey = "up";
        leftKey = "left";
        rightKey = "right";
    }

    public Keybindings(String jump, String left, String right) {
        jumpKey = jump;
        leftKey = left;
        rightKey = right;
    }
}
