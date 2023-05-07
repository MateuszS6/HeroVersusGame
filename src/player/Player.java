package player;

import characters.Character;
import characters.Knight;
import characters.Skeleton;
import characters.Wizard;
import city.cs.engine.*;
import arenas.BattleArena;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Walker implements ActionListener {
    public static final int MAX_HEALTH = 100;
    public static final int MAX_RESPAWNS = 3;
    private final BattleArena gameRound;
    private final int ID;
    private final Character character;
    private final Vec2 startPos;
    private KeyBindings keyBindings;
    private SolidFixture hitbox;
    private int
            health,
            respawns;
    private boolean
            isFacingRight,
            isMidAir,
            isRunning,
            isAttacking;

    /** Initialise a player. */
    public Player(BattleArena w,
                  int number,
                  Characters c,
                  Vec2 spawn) {
        super(w);
        gameRound = w;
        ID = number;
        character = switch (c) {
            case KNIGHT -> new Knight(this);
            case SKELETON -> new Skeleton(this);
            case WIZARD -> new Wizard(this);
        };
        startPos = spawn;

        hitbox = new SolidFixture(this, character.getDefaultShape());
        setGravityScale(2);

        health = MAX_HEALTH;
        respawns = MAX_RESPAWNS;

        isFacingRight = ID == 1;
        addImage(character.getIdleImage());
        isMidAir = false;
        isAttacking = false;

        setPosition(startPos);
        addCollisionListener(new Collisions(this));
    }

    public Character getCharacter() {
        return character;
    }

    public KeyBindings getKeyBindings() {
        return keyBindings;
    }

    public void setKeyBindings(int jump, int left, int right, int attack) {
        keyBindings = new KeyBindings(jump, left, right, attack);
    }

    public void setKeyBindings() {
        keyBindings = new KeyBindings();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getRespawns() {
        return respawns;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public boolean isMidAir() {
        return isMidAir;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void idle() {
        stopWalking();
        isRunning = false;

        removeAllImages();
        if (isMidAir) addImage(character.getJumpImage());
        else addImage(character.getIdleImage());
    }

    public void jump() {
        if (!isAttacking) {
            jump(character.getJumpSpeed());
            isMidAir = true;

            removeAllImages();
            addImage(character.getJumpImage());
        }
    }

    public void land() {
        isMidAir = false;

        removeAllImages();
        if (isRunning) addImage(character.getRunImage());
        else addImage(character.getIdleImage());
    }

    public void run(int direction) {
        if (!isAttacking) {
            startWalking(character.getRunSpeed() * direction);
            isRunning = true;

            if (direction == 1) isFacingRight = true;
            else if (direction == -1) isFacingRight = false;
            else throw new RuntimeException("Invalid direction chosen.");

            removeAllImages();
            if (isMidAir) addImage(character.getJumpImage());
            else addImage(character.getRunImage());
        }
    }

    public void attack() {
        if (isRunning) idle();
        if (!isMidAir && !isAttacking) {
            isAttacking = true;

            Timer timer = new Timer(character.getAttackDuration(), this);
            timer.setRepeats(false);
            timer.start();

            updateHitboxAndImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        isAttacking = false;
        updateHitboxAndImage();
    }

    public void updateHitboxAndImage() {
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

    public void resetHitbox() {
        hitbox.destroy();
        hitbox = new SolidFixture(this, character.getDefaultShape());
    }

    public void respawn() {
        if (respawns < 2 && health < 1) {
            respawns = 0;
            destroy();
            System.out.println("Player " + ID + " is defeated.");
            gameRound.setWinner(ID == 1 ? 2 : 1);
            gameRound.togglePause(true);
        } else if (health < 1) {
            isFacingRight = ID == 1;
            setPosition(startPos);

            health = MAX_HEALTH;
            respawns--;
        }
    }

    // TODO: 28/04/2023 Changeable player username, once text outline is implemented
    public void drawStatsBox(Graphics2D g, int w, int h, int x, int y) {
        // Save colour and font
        Color savedColour = g.getColor();
        Font savedFont = g.getFont();

        // Back panel
        g.setColor(new Color(0xFFFFFF));
        g.drawRoundRect(x, y, w, h, 10, 10);
        g.setColor(new Color(255, 255, 255, 65));
        g.fillRoundRect(x, y, w, h, 10, 10);
//        g.setColor(panel);
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