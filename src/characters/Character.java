package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public abstract class Character {
    private final PolygonShape DEFAULT_SHAPE;
    private final PolygonShape L_ATTACK_SHAPE;
    private final PolygonShape R_ATTACK_SHAPE;
    private final BodyImage L_IDLE_IMG;
    private final BodyImage R_IDLE_IMG;
    private final BodyImage L_JUMP_IMG;
    private final BodyImage R_JUMP_IMG;
    private final BodyImage L_RUN_IMG;
    private final BodyImage R_RUN_IMG;
    private final BodyImage L_ATTACK_IMG;
    private final BodyImage R_ATTACK_IMG;
    private final float RUN_SPEED;
    private final float JUMP_SPEED;
    private final int ATTACK_DUR;
    private final int ATTACK_DMG;

    public Character(PolygonShape defaultShape,
                     PolygonShape leftAttackShape,
                     PolygonShape rightAttackShape,
                     BodyImage leftIdleImage,
                     BodyImage rightIdleImage,
                     BodyImage leftJumpImage,
                     BodyImage rightJumpImage,
                     BodyImage leftRunImage,
                     BodyImage rightRunImage,
                     BodyImage leftAttackImage,
                     BodyImage rightAttackImage,
                     float runSpeed,
                     float jumpSpeed,
                     int attackDuration,
                     int attackDamage) {
        DEFAULT_SHAPE = defaultShape;
        L_ATTACK_SHAPE = leftAttackShape;
        R_ATTACK_SHAPE = rightAttackShape;
        L_IDLE_IMG = leftIdleImage;
        R_IDLE_IMG = rightIdleImage;
        L_JUMP_IMG = leftJumpImage;
        R_JUMP_IMG = rightJumpImage;
        L_RUN_IMG = leftRunImage;
        R_RUN_IMG = rightRunImage;
        L_ATTACK_IMG = leftAttackImage;
        R_ATTACK_IMG = rightAttackImage;
        RUN_SPEED = runSpeed;
        JUMP_SPEED = jumpSpeed;
        ATTACK_DUR = attackDuration;
        ATTACK_DMG = attackDamage;
    }

    public PolygonShape getDefaultShape() {
        return DEFAULT_SHAPE;
    }

    public PolygonShape getAttackShape(boolean playerFacingRight) {
        if (playerFacingRight) return R_ATTACK_SHAPE;
        else return L_ATTACK_SHAPE;
    }

    public BodyImage getIdleImage(boolean playerFacingRight) {
        if (playerFacingRight) return R_IDLE_IMG;
        else return L_IDLE_IMG;
    }

    public BodyImage getJumpImage(boolean playerFacingRight) {
        if (playerFacingRight) return R_JUMP_IMG;
        else return L_JUMP_IMG;
    }

    public BodyImage getRunImage(boolean playerFacingRight) {
        if (playerFacingRight) return R_RUN_IMG;
        else return L_RUN_IMG;
    }

    public BodyImage getAttackImage(boolean playerFacingRight) {
        if (playerFacingRight) return R_ATTACK_IMG;
        else return L_ATTACK_IMG;
    }

    public float getRunSpeed() {
        return RUN_SPEED;
    }

    public float getJumpSpeed() {
        return JUMP_SPEED;
    }

    public int getAttackDuration() {
        return ATTACK_DUR;
    }

    public int getAttackDamage() {
        return ATTACK_DMG;
    }
}