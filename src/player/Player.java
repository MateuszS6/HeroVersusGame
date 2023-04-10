package player;

import characters.Character;
import city.cs.engine.*;
import game.GameWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Walker implements ActionListener {
    private final Character character;
    private KeyBindings keyBindings;
    // private SolidFixture fixture;
    private Sensor hitboxSensor;
    private static final int MAX_HEALTH = 100;
    private int health;
    private static final int MAX_LIVES = 3;
    private int lives;
    private boolean isFacingRight;
    private boolean isMidAir;
    private boolean isAttacking;

    /** Initialise a player. */
    public Player(World world, Character character, boolean startFacingRight) {
        super(world, character.getDefaultShape());
        this.character = character;
        // fixture = new SolidFixture(this, character.getDefaultShape());
        // setAlwaysOutline(true);
        setGravityScale(2);

        health = MAX_HEALTH;
        lives = MAX_LIVES;

        isFacingRight = startFacingRight;
        addImage(character.getIdleImage(isFacingRight));

        isMidAir = false;
        isAttacking = false;
    }

    public Character getCharacter() {
        return character;
    }

    public KeyBindings getKeyBindings() {
        return keyBindings;
    }

    public Sensor getHitboxSensor() {
        return hitboxSensor;
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

    public void decrementLives() {
        lives--;
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
        if (isMidAir) addImage(character.getJumpImage(isFacingRight));
        else addImage(character.getIdleImage(isFacingRight));

        stopWalking();
    }

    public void jump() {
        removeAllImages();
        addImage(character.getJumpImage(isFacingRight));

        jump(character.getJumpSpeed());
    }

    public void runLeft() {
        isFacingRight = false;

        removeAllImages();
        if (isMidAir) addImage(character.getJumpImage(isFacingRight));
        else addImage(character.getRunImage(isFacingRight));

        startWalking(-character.getRunSpeed());
    }

    public void runRight() {
        isFacingRight = true;

        removeAllImages();
        if (isMidAir) addImage(character.getJumpImage(isFacingRight));
        else addImage(character.getRunImage(isFacingRight));

        startWalking(character.getRunSpeed());
    }

    public void attack() {
        if (!isMidAir && !isAttacking) {
            isAttacking = true;
            Timer timer = new Timer(character.getAttackDuration(), this);
            timer.setRepeats(false);
            timer.start();
            // fixture.destroy();

            removeAllImages();
            // fixture = new SolidFixture(this, character.getAttackShape(isFacingRight));
            hitboxSensor = new Sensor(this, character.getAttackShape(isFacingRight));
            hitboxSensor.addSensorListener(new HitboxDetection((GameWorld) getWorld(), this));
            addImage(character.getAttackImage(isFacingRight));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        isAttacking = false;
        // fixture.destroy();
        // fixture = new SolidFixture(this, character.getDefaultShape());
        hitboxSensor.removeAllSensorListeners();
        hitboxSensor.destroy();

        removeAllImages();
        addImage(character.getIdleImage(isFacingRight));
    }
}