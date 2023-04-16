package player;

import characters.Character;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Walker implements ActionListener {
    private final int NUM;
    private Character character;
    private KeyBindings keyBindings;
    private final Vec2 START_POS;
    private SolidFixture hitbox;
    private int health;
    private static final int MAX_HEALTH = 100;
    private int lives;
    private static final int MAX_LIVES = 3;
    private boolean isFacingRight;
    private boolean isMidAir;
    private boolean isAttacking;

    /** Initialise a player. */
    public Player(World world,
                  int num,
                  Character character,
                  Vec2 startPos) {
        super(world);

        NUM = num;
        this.character = character;
        this.character.setPlayer(this);
        START_POS = startPos;

        hitbox = new SolidFixture(this, character.getDefaultShape());
        // setAlwaysOutline(true);
        setGravityScale(2);

        health = MAX_HEALTH;
        lives = MAX_LIVES;

        isFacingRight = NUM == 1;
        addImage(character.getIdleImage());

        isMidAir = false;
        isAttacking = false;

        setPosition(START_POS);
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

    public void decrementLives() {
        lives--;
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

    public boolean isAttacking() {
        return isAttacking;
    }

    public void idle() {
        removeAllImages();
        if (isMidAir) addImage(character.getJumpImage());
        else addImage(character.getIdleImage());

        stopWalking();
    }

    public void jump() {
        removeAllImages();
        addImage(character.getJumpImage());

        jump(character.getJumpSpeed());
    }

    public void run(boolean facingRight) {
        isFacingRight = facingRight;

        removeAllImages();
        if (isMidAir) addImage(character.getJumpImage());
        else addImage(character.getRunImage());

        if (isFacingRight) startWalking(character.getRunSpeed());
        else startWalking(-character.getRunSpeed());
    }

    public void attack() {
        if (!isMidAir && !isAttacking) {
            isAttacking = true;

            Timer timer = new Timer(character.getAttackDuration(), this);
            timer.setRepeats(false);
            timer.start();

            updateHitbox();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        isAttacking = false;
        updateHitbox();
    }

    public void updateHitbox() {
        hitbox.destroy();
        removeAllImages();
        if (isAttacking) {
            hitbox = new SolidFixture(this, character.getAttackShape());
            addImage(character.getAttackImage());
        } else {
            hitbox = new SolidFixture(this, character.getDefaultShape());
            addImage(character.getIdleImage());
        }
    }

    public void respawn() {
        if (lives < 2) {

            lives = 0;
            destroy();
            System.out.println("Player " + NUM + " is dead.");

        } else if (health < 1) {

            isFacingRight = NUM == 1;
            setPosition(START_POS);

            health = MAX_HEALTH;
            decrementLives();
        }
    }
}