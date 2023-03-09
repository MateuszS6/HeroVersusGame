package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Knight implements Character {
    private final PolygonShape shape = new PolygonShape(
            -1.3f, -4.04f,
            0.31f, -4.04f,
            0.46f, -2.29f,
            -0.1f, -0.32f,
            -0.7f, -0.32f,
            -1.63f, -2.22f,
            -1.34f, -3.94f);
    private final BodyImage IDLE_LEFT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 8);
    private final BodyImage IDLE_RIGHT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 8);
    private final BodyImage JUMPING_LEFT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Jump.gif", 8);
    private final BodyImage JUMPING_RIGHT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Jump.gif", 8);
    private final BodyImage RUNNING_LEFT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Run.gif", 8);
    private final BodyImage RUNNING_RIGHT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Run.gif", 8);
    private final BodyImage ATTACK_LEFT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__AttackCombo2hit.gif", 8);
    private final BodyImage ATTACK_RIGHT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__AttackCombo2hit.gif", 8);
    private static final float RUNNING_SPEED = 5;
    private static final float JUMPING_SPEED = 10;

    @Override
    public PolygonShape getShape() {
        return shape;
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