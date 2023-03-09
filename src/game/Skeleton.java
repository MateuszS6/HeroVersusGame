package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.PolygonShape;

public class Skeleton implements Character {
    private final PolygonShape DEFAULT_SHAPE = new PolygonShape(
            -0.6f, -2.05f,
            0.75f, -2.08f,
            1.23f, -0.58f,
            0.6f, 1.19f,
            -0.6f, 1.19f,
            -1.05f, -0.58f,
            -0.72f, -1.96f);
    private final CircleShape ATTACK_AREA_SHAPE = new CircleShape(5);
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
            new BodyImage("assets/Skeleton/120x80_gifs/left_attack.gif", 10);
    private final BodyImage ATTACK_RIGHT_IMG =
            new BodyImage("assets/Skeleton/120x80_gifs/right_attack.gif", 10);
    private static final float RUNNING_SPEED = 3;
    private static final float JUMPING_SPEED = 10;

    @Override
    public PolygonShape getDefaultShape() {
        return DEFAULT_SHAPE;
    }

    @Override
    public CircleShape getAttackAreaShape() {
        return ATTACK_AREA_SHAPE;
    }

    @Override
    public BodyImage getIdleLeftImage() {
        return IDLE_LEFT_IMG;
    }

    @Override
    public BodyImage getIdleRightImage() {
        return IDLE_RIGHT_IMG;
    }

    @Override
    public BodyImage getJumpingLeftImage() {
        return JUMPING_LEFT_IMG;
    }

    @Override
    public BodyImage getJumpingRightImage() {
        return JUMPING_RIGHT_IMG;
    }

    @Override
    public BodyImage getRunningLeftImage() {
        return RUNNING_LEFT_IMG;
    }

    @Override
    public BodyImage getRunningRightImage() {
        return RUNNING_RIGHT_IMG;
    }

    @Override
    public BodyImage getAttackLeftImage() {
        return ATTACK_LEFT_IMG;
    }

    @Override
    public BodyImage getAttackRightImage() {
        return ATTACK_RIGHT_IMG;
    }

    @Override
    public float getRunningSpeed() {
        return RUNNING_SPEED;
    }

    @Override
    public float getJumpingSpeed() {
        return JUMPING_SPEED;
    }
}