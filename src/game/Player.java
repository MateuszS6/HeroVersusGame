package game;

import city.cs.engine.Walker;
import city.cs.engine.World;

public class Player extends Walker {
    private Character character;
    private Keybindings keybindings;
    private boolean isFacingRight;

    /** Initialise a player. */
    public Player(World world, Character character, boolean startFacingRight) {
        super(world, character.getShape());
        this.character = character;
        isFacingRight = startFacingRight;
        if (isFacingRight)
            addImage(character.getIdleRightImage());
        else
            addImage(character.getIdleLeftImage());
    }

    public Character getCharacter() {
        return character;
    }

    public Keybindings getKeybindings() {
        return keybindings;
    }

    public void setKeybindings(Keybindings keybindings) {
        this.keybindings = keybindings;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean facingRight) {
        isFacingRight = facingRight;
    }
}