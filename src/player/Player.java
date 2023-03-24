package player;

import characters.Character;
import city.cs.engine.SolidFixture;
import city.cs.engine.Walker;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Walker implements ActionListener {
    private final Character character;
    private KeyBindings keyBindings;
    private SolidFixture fixture;
    private int health;
    private static final int MAX_HEALTH = 100;
    private int lives;
    private static final int MAX_LIVES = 3;
    private boolean isFacingRight;
    private boolean isMidAir;
    private boolean isAttacking;

    /** Initialise a player. */
    public Player(World world, Character character, boolean startFacingRight) {
        super(world);
        this.character = character;
        fixture = new SolidFixture(this, character.getDefaultShape());
        // setAlwaysOutline(true);
        setGravityScale(2);

        health = MAX_HEALTH;
        lives = MAX_LIVES;

        isFacingRight = startFacingRight;
        if (isFacingRight)
            addImage(character.getIdleRightImage());
        else
            addImage(character.getIdleLeftImage());
        isMidAir = false;
        isAttacking = false;
    }

    public Character getCharacter() {
        return character;
    }

    public KeyBindings getKeyBindings() {
        return keyBindings;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void decrementlives() {
        lives--;
    }

    public int getMaxLives() {
        return MAX_LIVES;
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

    public void setMidAir(boolean midAir) {
        isMidAir = midAir;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void idle() {
        removeAllImages();
        if (isMidAir) {
            if (isFacingRight)
                addImage(getCharacter().getJumpingRightImage());
            else
                addImage(getCharacter().getJumpingLeftImage());
        } else {
            if (isFacingRight)
                addImage(getCharacter().getIdleRightImage());
            else
                addImage(getCharacter().getIdleLeftImage());
        }
        stopWalking();
    }

    public void jump() {
        removeAllImages();
        if (isFacingRight)
            addImage(getCharacter().getJumpingRightImage());
        else
            addImage(getCharacter().getJumpingLeftImage());
        jump(getCharacter().getJumpingSpeed());
    }

    public void moveLeft() {
        isFacingRight = false;
        removeAllImages();
        if (isMidAir) {
            if (isFacingRight)
                addImage(getCharacter().getJumpingRightImage());
            else
                addImage(getCharacter().getJumpingLeftImage());
        } else {
            addImage(getCharacter().getRunningLeftImage());
        }
        startWalking(-getCharacter().getRunningSpeed());
    }

    public void moveRight() {
        isFacingRight = true;
        removeAllImages();
        if (isMidAir) {
            if (isFacingRight)
                addImage(getCharacter().getJumpingRightImage());
            else
                addImage(getCharacter().getJumpingLeftImage());
        } else {
            addImage(getCharacter().getRunningRightImage());
        }
        startWalking(getCharacter().getRunningSpeed());
    }

    public void attack() {
        if (!isMidAir && !isAttacking) {
            isAttacking = true;
            Timer timer = new Timer(getCharacter().getAttackDuration(), this);
            timer.setRepeats(false);
            timer.start();
            fixture.destroy();
            removeAllImages();
            if (isFacingRight) {
                fixture = new SolidFixture(this, character.getAttackRightShape());
                addImage(getCharacter().getAttackRightImage());
            } else {
                fixture = new SolidFixture(this, character.getAttackLeftShape());
                addImage(getCharacter().getAttackLeftImage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        isAttacking = false;
        fixture.destroy();
        fixture = new SolidFixture(this, character.getDefaultShape());
        removeAllImages();
        if (isFacingRight)
            addImage(getCharacter().getIdleRightImage());
        else
            addImage(getCharacter().getIdleLeftImage());
    }
}