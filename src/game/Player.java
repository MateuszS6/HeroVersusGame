package game;

import city.cs.engine.*;

public class Player extends Walker {
    private Character character;
    private KeyBindings keyBindings;
    private boolean isFacingRight;
    private boolean isMidAir;
    private SolidFixture hitbox;
    private boolean isAttacking;
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

        hitbox = new SolidFixture(this, character.getDefaultShape());
        hitbox.setFriction(70);
        leftAttackArea = new GhostlyFixture(this, character.getAttackLeftShape());
        rightAttackArea = new GhostlyFixture(this, character.getAttackRightShape());

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

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public boolean isMidAir() {
        return isMidAir;
    }

    public void setMidAir(boolean midAir) {
        isMidAir = midAir;
    }

    public SolidFixture getHitbox() {
        return hitbox;
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
            addImage(idleRightImg);
        else
            addImage(idleLeftImg);
        stopWalking();
    }

    public void jump() {
        removeAllImages();
        if (isFacingRight)
            addImage(jumpingRightImg);
        else
            addImage(jumpingLeftImg);
        jump(jumpingSpeed);
    }

    public void moveLeft() {
        isFacingRight = false;
        if (!isMidAir) {
            removeAllImages();
            addImage(runningLeftImg);
        }
        startWalking(-runningSpeed);
    }

    public void moveRight() {
        isFacingRight = true;
        if (!isMidAir) {
            removeAllImages();
            addImage(runningRightImg);
        }
        startWalking(runningSpeed);
    }

    public void attack() {
        if (!isMidAir) {
            removeAllImages();
            if (isFacingRight)
                addImage(attackRightImg);
            else
                addImage(attackLeftImg);
            isAttacking = true;
        }
    }
}