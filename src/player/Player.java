package player;

import characters.Character;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
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
            respawns;
    private static final int MAX_HEALTH = 100;
    private static final int MAX_RESPAWNS = 3;
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
        setAlwaysOutline(false);
        setGravityScale(2);

        health = MAX_HEALTH;
        respawns = MAX_RESPAWNS;

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

    public void setKeyBindings(KeyBindings keybindings) {
        this.keyBindings = keybindings;
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

    public int getRespawns() {
        return respawns;
    }

    public void decrementRespawns() {
        respawns--;
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
        if (respawns < 2 && health < 1) {
            respawns = 0;
            destroy();
            System.out.println("Player " + ID + " is defeated.");

        } else if (health < 1) {
            isFacingRight = ID == 1;
            setPosition(startPos);

            health = MAX_HEALTH;
            decrementRespawns();
        }
    }

    public void drawHUD(Graphics2D g, int w, int h, int x, int y) {
        // Save colour and font
        Color savedColour = g.getColor();
        Font savedFont = g.getFont();

        Color panelBlack = new Color(0, 0, 0, 65);

        // Back panel
        g.setColor(panelBlack);
        g.fillRoundRect(x, y, w, h, 10, 10);
//        g.setColor(panelBlack);
//        g.fillRect(x + 2, y + 2, w - 4, h - 4);

        // Name
        g.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        g.setColor(Color.BLACK);
        g.drawString("Player " + ID, x + 7, y + 20);

        // Health bar
        int xPos = x + 7;
        int yPos = y + 25;
        int width = w - 14;
        int height = 15;
        g.setColor(Color.RED);
        g.fillRect(xPos, yPos, width, height);
        float factor = (float) health / 100;
        g.setColor(Color.GREEN);
        g.fillRect(xPos, yPos, (int) (width * factor), height);

        // Lives
        g.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        g.setColor(Color.BLACK);
        g.drawString("Respawns: " + respawns, x + 7, y + 55);

        // Reset to saved colour and font
        g.setColor(savedColour);
        g.setFont(savedFont);
    }
}