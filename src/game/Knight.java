package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.PolygonShape;
import org.jbox2d.common.Vec2;

public class Knight implements Character {
    private final PolygonShape DEFAULT_SHAPE = new PolygonShape(
            -0.2f, -0.1f,
            1.25f, -2.05f,
            0.5f, -4.0f,
            -1.0f, -4.0f,
            -1.8f, -2.05f,
            -0.3f, -0.1f);
    private final CircleShape ATTACK_LEFT_SHAPE = new CircleShape(2.5f, new Vec2(-1.8f, -2.05f));
    // 0.41f, -4.06f, 0.74f, -2.26f, -0.7f, -0.34f, -2.98f, 0.74f, -5.64f, -0.34f, -5.62f, -4.04f, 0.24f, -4.06f
    private final CircleShape ATTACK_RIGHT_SHAPE = new CircleShape(2.5f, new Vec2(1.25f, -2.05f));
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
    private static final float RUNNING_SPEED = 8;
    private static final float JUMPING_SPEED = 10;

    @Override
    public PolygonShape getDefaultShape() {
        return DEFAULT_SHAPE;
    }

    @Override
    public CircleShape getAttackLeftShape() {
        return ATTACK_LEFT_SHAPE;
    }

    @Override
    public CircleShape getAttackRightShape() {
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
}