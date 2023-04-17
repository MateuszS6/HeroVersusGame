package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Skeleton extends Character {
    public Skeleton() {
        super(new PolygonShape(
                -0.7f, -2.05f,
                        0.7f, -2.05f,
                        1.25f, -0.6f,
                        0.6f, 1.19f,
                        -0.6f, 1.19f,
                        -1.25f, -0.6f
                ),
                new PolygonShape(
                        1.23f, -2.08f,
                        -3.42f, -2.08f,
                        -3.45f, 1.07f,
                        -1.2f, 2.6f,
                        1.17f, 2.57f
                ),
                new PolygonShape(
                        -1.23f, -2.08f,
                        3.42f, -2.08f,
                        3.45f, 1.07f,
                        1.2f, 2.6f,
                        -1.17f, 2.57f
                ),
                new BodyImage("assets/Skeleton/120x80_gifs/left_idle.gif", 10),
                new BodyImage("assets/Skeleton/120x80_gifs/right_idle.gif", 10),
                new BodyImage("assets/Skeleton/120x80_gifs/left_idle.gif", 10),
                new BodyImage("assets/Skeleton/120x80_gifs/right_idle.gif", 10),
                new BodyImage("assets/Skeleton/120x80_gifs/left_walk.gif", 10),
                new BodyImage("assets/Skeleton/120x80_gifs/right_walk.gif", 10),
                new BodyImage("assets/Skeleton/120x80_gifs/left_attack2.gif", 10),
                new BodyImage("assets/Skeleton/120x80_gifs/right_attack2.gif", 10),
                7,
                15,
                1700,
                40);
    }
}