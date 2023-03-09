package game;

import city.cs.engine.GhostlyFixture;
import city.cs.engine.SolidFixture;
import city.cs.engine.Walker;
import city.cs.engine.World;

public class Player extends Walker {
    private Character character;
    private KeyBindings keyBindings;
    private boolean isFacingRight;
    private GhostlyFixture leftAttackArea;
    private GhostlyFixture rightAttackArea;

    /** Initialise a player. */
    public Player(World world, Character character, boolean startFacingRight) {
        super(world, character.getDefaultShape());
        this.character = character;
        isFacingRight = startFacingRight;
        SolidFixture fixture = new SolidFixture(this, character.getDefaultShape());
        fixture.setFriction(70);
        leftAttackArea = new GhostlyFixture(this, character.getAttackLeftShape());
        rightAttackArea = new GhostlyFixture(this, character.getAttackRightShape());
        if (isFacingRight)
            addImage(character.getIdleRightImage());
        else
            addImage(character.getIdleLeftImage());
    }

    public Character getCharacter() {
        return character;
    }

    public KeyBindings getKeyBindings() {
        return keyBindings;
    }

    public void setKeyBindings(KeyBindings keybindings) {
        this.keyBindings = keybindings;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean facingRight) {
        isFacingRight = facingRight;
    }

    public GhostlyFixture getLeftAttackArea() {
        return leftAttackArea;
    }

    public GhostlyFixture getRightAttackArea() {
        return rightAttackArea;
    }
}