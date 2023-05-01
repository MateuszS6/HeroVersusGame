package game;

import arenas.Royal;
import city.cs.engine.World;
import player.Characters;
import player.Player;
import world.DeathZone;
import world.SideBorder;
import world.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

public abstract class BattleArena extends World {
    // TODO: 24/04/2023
    //  1 life, best of 3, winning player chooses next arena to play in
    // TODO: 24/04/2023
    //  Add PRACTICE ARENA with grey tiles - unlimited respawns, advances to arenas on completion OR on SKIP button
    // TODO: 24/04/2023
    //  Desert arena, minimalistic/paper arena
    private Game game;
    private String name;
    private Color bgColour;
    private Image bgImage;
    private String tilePath;
    private final Player
            player1,
            player2;
    private final SideBorder
            left,
            right;
    private DeathZone deathZone;

    /** Initialise a game world. */
    public BattleArena(Game g,
                       float x1,
                       float x2,
                       float y1,
                       float y2) {
        game = g;

        // Player-teleporting world borders
        left = new SideBorder(this, -21);
        right = new SideBorder(this, 21);

        // Player 1
        player1 = new Player(this, 1, Characters.KNIGHT, x1, y1);
        player1.setKeyBindings(KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_R);

        // Player 2
        player2 = new Player(this, 2, Characters.SKELETON, x2, y2);
        player2.setKeyBindings();

        // Fill the world with tiles
        populate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getBgColour() {
        return bgColour;
    }

    public Image getBgImage() {
        return bgImage;
    }

    public void setBackground(Color color) {
        bgColour = color;
    }

    public void setBackground(String fileName) {
        bgImage = new ImageIcon(fileName).getImage();
    }

    public void setTilePath(String tilePath) {
        this.tilePath = tilePath;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public SideBorder getOtherSide(SideBorder thisSide) {
        return thisSide == left ? right : left;
    }

    public void setDeathZone(BattleArena w, float y) {
        if (deathZone == null) deathZone = new DeathZone(w, right.getPosition().x, y);
    }

    public void placeBlock(String type, float x, float y) {
        new Tile(this, tilePath + "/" + type, x, y);
    }

    public abstract void populate();

    public void drawHUD(Graphics2D g, int scrW, int scrH, Point2D.Float p1, Point2D.Float p2) {
        Color label = new Color(255, 255, 255, 165);
        String font = "Bahnschrift";

        if (this instanceof Royal) g.setColor(Color.BLACK);
        else g.setColor(Color.WHITE);
        g.setFont(new Font(font, Font.BOLD, 20));
        g.drawString(name, (scrW / 2) - 60, 30);

        g.setColor(label);
        g.setFont(new Font(font, Font.BOLD, 15));

        int w = 120;
        int h = 65;
        int x = 10; // (scrW / 2) - (w + 5);
        int y = 10;

        // Player 1 HUD
        player1.drawStatsBox(g, w, h, x, y);
        if (player1.getRespawns() > 0) g.drawString("Player 1", p1.x - 30, p1.y - 5);

        // Player 2 HUD
        player2.drawStatsBox(g, w, h, scrW - (w + x), y);
        if (player2.getRespawns() > 0) g.drawString("Player 2", p2.x - 30, p2.y - 45);
    }

    public void isComplete(int winnerID) {
        System.out.println("Player " + winnerID + " is the arena champion.");
    }
}