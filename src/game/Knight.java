package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Knight implements Character {
    private final PolygonShape DEFAULT_SHAPE = new PolygonShape(
            -0.3f, -0.1f,
            1.25f, -2.05f,
            0.5f, -4.0f,
            -1.0f, -4.0f,
            -1.8f, -2.05f);
    private final PolygonShape ATTACK_LEFT_SHAPE = new PolygonShape(0.72f,-4.06f, -1.68f,-4.06f, -4.06f,-3.56f, -5.52f,-1.66f, -3.12f,0.52f, 0.0f,-0.44f, 1.32f,-2.26f);
    private final PolygonShape ATTACK_RIGHT_SHAPE = new PolygonShape(-0.72f,-4.06f, 1.8f,-4.06f, 4.46f,-3.68f, 5.4f,-1.78f, 2.64f,0.5f, -0.1f,-0.34f, -1.2f,-2.46f);
    private final BodyImage IDLE_LEFT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/left_idle.gif", 8);
    private final BodyImage IDLE_RIGHT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 8);
    private final BodyImage JUMPING_LEFT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/left_jump.gif", 8);
    private final BodyImage JUMPING_RIGHT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Jump.gif", 8);
    private final BodyImage RUNNING_LEFT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/left_run.gif", 8);
    private final BodyImage RUNNING_RIGHT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Run.gif", 8);
    private final BodyImage ATTACK_LEFT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/left_attack.gif", 8);
    private final BodyImage ATTACK_RIGHT_IMG =
            new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__AttackCombo2hit.gif", 8);
    private static final float RUNNING_SPEED = 11;
    private static final float JUMPING_SPEED = 15;
    private static final int ATTACK_DURATION = 500;

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