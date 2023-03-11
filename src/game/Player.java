package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Walker implements ActionListener {
    private final Character character;
    private KeyBindings keyBindings;
    private int health;
    private static final int MAX_HEALTH = 100;
    private boolean isFacingRight;
    private boolean isMidAir;
    private boolean isAttacking;

    /** Initialise a player. */
    public Player(World world, Character character, boolean startFacingRight) {
        super(world, character.getDefaultShape());
        this.character = character;
        setGravityScale(2);

        health = 100;

        isFacingRight = startFacingRight;
        if (isFacingRight)
            addImage(character.getIdleRightImage());
        else
            addImage(character.getIdleLeftImage());
        isMidAir = false;
        isAttacking = false;

        addCollisionListener(new PlayerCollisions(this));
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

    public void setKeyBindings(KeyBindings keybindings) {
        this.keyBindings = keybindings;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setMidAir(boolean midAir) {
        isMidAir = midAir;
    }

    public void idle() {
        if (isMidAir) {
            jump();
        } else {
            removeAllImages();
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
        if (isMidAir) {
            jump();
        } else {
            removeAllImages();
            addImage(getCharacter().getRunningLeftImage());
        }
        startWalking(-getCharacter().getRunningSpeed());
    }

    public void moveRight() {
        isFacingRight = true;
        if (isMidAir) {
            jump();
        } else {
            removeAllImages();
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
            removeAllImages();
            if (isFacingRight)
                addImage(getCharacter().getAttackRightImage());
            else
                addImage(getCharacter().getAttackLeftImage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // count attack here
        idle();
        isAttacking = false;
    }
}