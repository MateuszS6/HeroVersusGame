package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Knight extends Character {
    public Knight() {
        super(new PolygonShape(
                        -0.3f, -0.1f,
                        1.25f, -2.05f,
                        0.5f, -4.0f,
                        -1.0f, -4.0f,
                        -1.8f, -2.05f
                ),
                new PolygonShape(
                        0.72f, -4.0f,
                        -1.68f, -4.0f,
                        -4.06f, -3.56f,
                        -5.52f, -1.66f,
                        -3.12f, 0.52f,
                        0.0f, -0.44f,
                        1.32f, -2.26f
                ),
                new PolygonShape(
                        -0.72f, -4.0f,
                        1.8f, -4.0f,
                        4.46f, -3.68f,
                        5.4f, -1.78f,
                        2.64f, 0.5f,
                        -0.1f, -0.34f,
                        -1.2f, -2.46f
                ),
                new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/left_idle.gif", 8),
                new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 8),
                new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/left_jump.gif", 8),
                new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Jump.gif", 8),
                new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/left_run.gif", 8),
                new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Run.gif", 8),
                new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/left_attack.gif", 8),
                new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__AttackCombo2hit.gif", 8),
                11,
                15,
                500,
                20);
    }
}