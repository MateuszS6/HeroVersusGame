package game;

import city.cs.engine.*;

public class Player extends Walker {
    private Character character;
    private GhostlyFixture leftAttackArea;
    private GhostlyFixture rightAttackArea;
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
    private KeyBindings keyBindings;
    private boolean isFacingRight;

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

    {
        idleLeftImg = getCharacter().getIdleLeftImage();
        idleRightImg = getCharacter().getIdleRightImage();
        jumpingLeftImg = getCharacter().getJumpingLeftImage();
        jumpingRightImg = getCharacter().getJumpingRightImage();
        runningLeftImg = getCharacter().getRunningLeftImage();
        runningRightImg = getCharacter().getRunningRightImage();
        attackLeftImg = getCharacter().getAttackLeftImage();
        attackRightImg = getCharacter().getAttackRightImage();

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

    public void jump() {
        if (isFacingRight) {
            removeAllImages();
            addImage(jumpingRightImg);
        } else {
            removeAllImages();
            addImage(jumpingLeftImg);
        }
        jump(jumpingSpeed);
    }

    public void moveLeft() {
        isFacingRight = false;
        removeAllImages();
        addImage(runningLeftImg);
        startWalking(-runningSpeed);
    }

    public void moveRight() {
        isFacingRight = true;
        removeAllImages();
        addImage(runningRightImg);
        startWalking(runningSpeed);
    }

    public void attack() {
        if (isFacingRight) {
            removeAllImages();
            addImage(attackRightImg);
        } else {
            removeAllImages();
            addImage(attackLeftImg);
        }
    }
}