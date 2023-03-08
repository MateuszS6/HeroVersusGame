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
    private final BodyImage idleLeftImage =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 8);
    private final BodyImage idleRightImage =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 8);
    private final BodyImage jumpingLeftImage =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Jump.gif", 8);
    private final BodyImage jumpingRightImage =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Jump.gif", 8);
    private final BodyImage runningLeftImage =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Run", 8);
    private final BodyImage runningRightImage =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Run.gif", 8);
    private final BodyImage attackLeftImage =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__AttackCombo2hit.gif", 8);
    private final BodyImage attackRightImage =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__AttackCombo2hit.gif", 8);
    private static final float RUNNING_SPEED = 10;
    private static final float JUMPING_SPEED = 10;

    @Override
    public PolygonShape getShape() {
        return shape;
    }

    @Override
    public BodyImage getIdleLeftImage() {
        return idleLeftImage;
    }

    @Override
    public BodyImage getIdleRightImage() {
        return idleRightImage;
    }

    @Override
    public BodyImage getJumpingLeftImage() {
        return jumpingLeftImage;
    }

    @Override
    public BodyImage getJumpingRightImage() {
        return jumpingRightImage;
    }

    @Override
    public BodyImage getRunningLeftImage() {
        return runningLeftImage;
    }

    @Override
    public BodyImage getRunningRightImage() {
        return runningRightImage;
    }

    @Override
    public BodyImage getAttackLeftImage() {
        return attackLeftImage;
    }

    @Override
    public BodyImage getAttackRightImage() {
        return attackRightImage;
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