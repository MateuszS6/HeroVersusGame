package player;

import characters.Character;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Walker implements ActionListener {
    private final int ID;
    private Character character;
    private KeyBindings keyBindings;
    private final Vec2 startPos;
    private SolidFixture hitbox;
    private int
            health,
            lives;
    private static final int MAX_HEALTH = 100;
    private static final int MAX_LIVES = 3;
    private boolean
            isFacingRight,
            isMidAir,
            isAttacking;

    /** Initialise a player. */
    public Player(World world,
                  int ID,
                  Character character,
                  Vec2 startPos) {
        super(world);

        this.ID = ID;
        this.character = character;
        this.character.setPlayer(this);
        this.startPos = startPos;

        hitbox = new SolidFixture(this, character.getDefaultShape());
        // setAlwaysOutline(true);
        setGravityScale(2);

        health = MAX_HEALTH;
        lives = MAX_LIVES;

        isFacingRight = this.ID == 1;
        addImage(character.getIdleImage());

        isMidAir = false;
        isAttacking = false;

        setPosition(this.startPos);
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

    public void run(int direction) {
        if (direction == 1) isFacingRight = true;
        else if (direction == -1) isFacingRight = false;

        removeAllImages();
        if (isMidAir) addImage(character.getJumpImage());
        else addImage(character.getRunImage());

        startWalking(character.getRunSpeed() * direction);
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
            System.out.println("Player " + ID + " is dead.");

        } else if (health < 1) {

            isFacingRight = ID == 1;
            setPosition(startPos);

            health = MAX_HEALTH;
            decrementLives();
        }
    }
}