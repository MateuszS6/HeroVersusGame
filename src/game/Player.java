package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Walker implements ActionListener {
    private Character character;
    private KeyBindings keyBindings;
    private boolean isFacingRight;
    private boolean isMidAir;
    private boolean isAttacking;
    private float runningSpeed;
    private float jumpingSpeed;

    /** Initialise a player. */
    public Player(World world, Character character, boolean startFacingRight) {
        super(world, character.getDefaultShape());
        this.character = character;
        setGravityScale(2);

        isFacingRight = startFacingRight;
        if (isFacingRight)
            addImage(character.getIdleRightImage());
        else
            addImage(character.getIdleLeftImage());
        isMidAir = false;
        isAttacking = false;

        runningSpeed = getCharacter().getRunningSpeed();
        jumpingSpeed = getCharacter().getJumpingSpeed();

        addCollisionListener(new PlayerCollisions(this));
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
        jump(jumpingSpeed);
    }

    public void moveLeft() {
        isFacingRight = false;
        if (isMidAir) {
            jump();
        } else {
            removeAllImages();
            addImage(getCharacter().getRunningLeftImage());
        }
        startWalking(-runningSpeed);
    }

    public void moveRight() {
        isFacingRight = true;
        if (isMidAir) {
            jump();
        } else {
            removeAllImages();
            addImage(getCharacter().getRunningRightImage());
        }
        startWalking(runningSpeed);
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