package game;

import city.cs.engine.*;

public class Player extends Walker {
    private Character character;
    private KeyBindings keyBindings;
    private boolean isFacingRight;
    private boolean isMidAir;
    private boolean isAttacking;
    private GhostlyFixture leftAttackArea;
    private GhostlyFixture rightAttackArea;
    private float runningSpeed;
    private float jumpingSpeed;

    /** Initialise a player. */
    public Player(World world, Character character, boolean startFacingRight) {
        super(world, character.getDefaultShape());
        this.character = character;
        isFacingRight = startFacingRight;
        if (isFacingRight)
            addImage(character.getIdleRightImage());
        else
            addImage(character.getIdleLeftImage());
        isMidAir = false;

        isAttacking = false;
        leftAttackArea = new GhostlyFixture(this, character.getAttackLeftShape());
        rightAttackArea = new GhostlyFixture(this, character.getAttackRightShape());

        runningSpeed = getCharacter().getRunningSpeed();
        jumpingSpeed = getCharacter().getJumpingSpeed();
    }

    public Character getCharacter() {
        return character;
    }

    public GhostlyFixture getLeftAttackArea() {
        return leftAttackArea;
    }

    public GhostlyFixture getRightAttackArea() {
        return rightAttackArea;
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

    public boolean isMidAir() {
        return isMidAir;
    }

    public void setMidAir(boolean midAir) {
        isMidAir = midAir;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    public void idle() {
        // isAttacking = false;
        removeAllImages();
        if (isFacingRight)
            addImage(getCharacter().getIdleRightImage());
        else
            addImage(getCharacter().getIdleLeftImage());
        stopWalking();
    }

    public void jump() {
        removeAllImages();
        if (isFacingRight)
            addImage(getCharacter().getJumpingRightImage());
        else
            addImage(getCharacter().getJumpingLeftImage());
        jump(jumpingSpeed);
    }

    public void moveLeft() {
        isFacingRight = false;
        if (!isMidAir) {
            removeAllImages();
            addImage(getCharacter().getRunningLeftImage());
        }
        startWalking(-runningSpeed);
    }

    public void moveRight() {
        isFacingRight = true;
        if (!isMidAir) {
            removeAllImages();
            addImage(getCharacter().getRunningRightImage());
        }
        startWalking(runningSpeed);
    }

    public void attack() {
        if (!isMidAir) {
            removeAllImages();
            if (isFacingRight)
                addImage(getCharacter().getAttackRightImage());
            else
                addImage(getCharacter().getAttackLeftImage());
            isAttacking = true;
        }
    }
}