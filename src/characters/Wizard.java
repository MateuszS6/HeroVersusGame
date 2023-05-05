package characters;

import city.cs.engine.PolygonShape;
import player.Player;

public final class Wizard extends Character {
    public Wizard(Player p) {
        super(p,
                new PolygonShape(
                        -0.5f, -1.3f,
                        0.5f, -1.3f,
                        1.5f, 0.2f,
                        0.1f, 1.5f,
                        -1.5f, 0.2f
                ),
                null,
                null,
                "assets/character/Wizard/gif/",
                "l_idle.gif",
                "r_idle.gif",
                "l_jump.gif",
                "r_jump.gif",
                "l_run.gif",
                "r_run.gif",
                "l_attack.gif",
                "r_attack.gif",
                8,
                0,
                0,
                800,
                25);
    }
}