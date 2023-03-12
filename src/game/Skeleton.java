package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Skeleton implements Character {
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

    @Override
    public PolygonShape getDefaultShape() {
        return DEFAULT_SHAPE;
    }

    @Override
    public PolygonShape getAttackLeftShape() {
        return ATTACK_LEFT_SHAPE;
    }

    @Override
    public PolygonShape getAttackRightShape() {
        return ATTACK_RIGHT_SHAPE;
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

    @Override
    public int getAttackDuration() {
        return ATTACK_DURATION;
    }
}