package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Skeleton extends Character {

    public Skeleton() {
        super(DEFAULT_SHAPE,
                ATTACK_LEFT_SHAPE,
                ATTACK_RIGHT_SHAPE,
                IDLE_LEFT_IMG,
                IDLE_RIGHT_IMG,
                JUMPING_LEFT_IMG,
                JUMPING_RIGHT_IMG,
                RUNNING_LEFT_IMG,
                RUNNING_RIGHT_IMG,
                ATTACK_LEFT_IMG,
                ATTACK_RIGHT_IMG,
                RUNNING_SPEED,
                JUMPING_SPEED,
                ATTACK_DURATION,
                ATTACK_DAMAGE);
    }
    private final PolygonShape DEFAULT_SHAPE = new PolygonShape(
            -0.7f, -2.05f,
            0.7f, -2.05f,
            1.25f, -0.6f,
            0.6f, 1.19f,
            -0.6f, 1.19f,
            -1.25f, -0.6f);
    private final PolygonShape ATTACK_LEFT_SHAPE = new PolygonShape(
            1.23f, -2.08f,
            -3.42f, -2.08f,
            -3.45f, 1.07f,
            -1.2f, 2.6f,
            1.17f, 2.57f);
    private final PolygonShape ATTACK_RIGHT_SHAPE = new PolygonShape(
            -1.23f, -2.08f,
            3.42f, -2.08f,
            3.45f, 1.07f,
            1.2f, 2.6f,
            -1.17f, 2.57f);

    private final BodyImage IDLE_LEFT_IMG =
            new BodyImage("assets/Skeleton/120x80_gifs/left_idle.gif", 10);
    private final BodyImage IDLE_RIGHT_IMG =
            new BodyImage("assets/Skeleton/120x80_gifs/right_idle.gif", 10);
    private final BodyImage JUMPING_LEFT_IMG =
            IDLE_LEFT_IMG;
    private final BodyImage JUMPING_RIGHT_IMG =
            IDLE_RIGHT_IMG;
    private final BodyImage RUNNING_LEFT_IMG =
            new BodyImage("assets/Skeleton/120x80_gifs/left_walk.gif", 10);
    private final BodyImage RUNNING_RIGHT_IMG =
            new BodyImage("assets/Skeleton/120x80_gifs/right_walk.gif", 10);
    private final BodyImage ATTACK_LEFT_IMG =
            new BodyImage("assets/Skeleton/120x80_gifs/left_attack2.gif", 10);
    private final BodyImage ATTACK_RIGHT_IMG =
            new BodyImage("assets/Skeleton/120x80_gifs/right_attack2.gif", 10);
    private static final float RUNNING_SPEED = 7;
    private static final float JUMPING_SPEED = 15;
    private static final int ATTACK_DURATION = 1700;
    private static final int ATTACK_DAMAGE = 40;
}