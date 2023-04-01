package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public abstract class Character {
    private final PolygonShape DEFAULT_SHAPE;
    private final PolygonShape ATTACK_LEFT_SHAPE;
    private final PolygonShape ATTACK_RIGHT_SHAPE;
    private final BodyImage IDLE_LEFT_IMG;
    private final BodyImage IDLE_RIGHT_IMG;
    private final BodyImage JUMPING_LEFT_IMG;
    private final BodyImage JUMPING_RIGHT_IMG;
    private final BodyImage RUNNING_LEFT_IMG;
    private final BodyImage RUNNING_RIGHT_IMG;
    private final BodyImage ATTACK_LEFT_IMG;
    private final BodyImage ATTACK_RIGHT_IMG;
    private final float RUNNING_SPEED;
    private final float JUMPING_SPEED;
    private final int ATTACK_DURATION;
    private final int ATTACK_DAMAGE;

    public Character(PolygonShape DEFAULT_SHAPE,
                     PolygonShape ATTACK_LEFT_SHAPE,
                     PolygonShape ATTACK_RIGHT_SHAPE,
                     BodyImage IDLE_LEFT_IMG,
                     BodyImage IDLE_RIGHT_IMG,
                     BodyImage JUMPING_LEFT_IMG,
                     BodyImage JUMPING_RIGHT_IMG,
                     BodyImage RUNNING_LEFT_IMG,
                     BodyImage RUNNING_RIGHT_IMG,
                     BodyImage ATTACK_LEFT_IMG,
                     BodyImage ATTACK_RIGHT_IMG,
                     float RUNNING_SPEED,
                     float JUMPING_SPEED,
                     int ATTACK_DURATION,
                     int ATTACK_DAMAGE) {
        this.DEFAULT_SHAPE = DEFAULT_SHAPE;
        this.ATTACK_LEFT_SHAPE = ATTACK_LEFT_SHAPE;
        this.ATTACK_RIGHT_SHAPE = ATTACK_RIGHT_SHAPE;
        this.IDLE_LEFT_IMG = IDLE_LEFT_IMG;
        this.IDLE_RIGHT_IMG = IDLE_RIGHT_IMG;
        this.JUMPING_LEFT_IMG = JUMPING_LEFT_IMG;
        this.JUMPING_RIGHT_IMG = JUMPING_RIGHT_IMG;
        this.RUNNING_LEFT_IMG = RUNNING_LEFT_IMG;
        this.RUNNING_RIGHT_IMG = RUNNING_RIGHT_IMG;
        this.ATTACK_LEFT_IMG = ATTACK_LEFT_IMG;
        this.ATTACK_RIGHT_IMG = ATTACK_RIGHT_IMG;
        this.RUNNING_SPEED = RUNNING_SPEED;
        this.JUMPING_SPEED = JUMPING_SPEED;
        this.ATTACK_DURATION = ATTACK_DURATION;
        this.ATTACK_DAMAGE = ATTACK_DAMAGE;
    }

    public PolygonShape getDefaultShape() {
        return DEFAULT_SHAPE;
    }

    public PolygonShape getAttackShape(boolean playerFacingRight) {
        if (playerFacingRight) return ATTACK_RIGHT_SHAPE;
        else return ATTACK_LEFT_SHAPE;
    }

    public BodyImage getIdleImage(boolean playerFacingRight) {
        if (playerFacingRight) return IDLE_RIGHT_IMG;
        else return IDLE_LEFT_IMG;
    }

    public BodyImage getJumpingImage(boolean playerFacingRight) {
        if (playerFacingRight) return JUMPING_RIGHT_IMG;
        else return JUMPING_LEFT_IMG;
    }

    public BodyImage getRunningImage(boolean playerFacingRight) {
        if (playerFacingRight) return RUNNING_RIGHT_IMG;
        else return RUNNING_LEFT_IMG;
    }

    public BodyImage getAttackImage(boolean playerFacingRight) {
        if (playerFacingRight) return ATTACK_RIGHT_IMG;
        else return ATTACK_LEFT_IMG;
    }

    public float getRunningSpeed() {
        return RUNNING_SPEED;
    }

    public float getJumpingSpeed() {
        return JUMPING_SPEED;
    }

    public int getAttackDuration() {
        return ATTACK_DURATION;
    }

    public int getAttackDamage() {
        return ATTACK_DAMAGE;
    }
}