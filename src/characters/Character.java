package characters;

import city.cs.engine.*;

public abstract class Character {
    private final PolygonShape DEFAULT_SHP;
    private final CircleShape L_ATTACK_SHP;
    private final CircleShape R_ATTACK_SHP;
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
                     CircleShape leftAttackShape,
                     CircleShape rightAttackShape,
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
        DEFAULT_SHP = defaultShape;
        L_ATTACK_SHP = leftAttackShape;
        R_ATTACK_SHP = rightAttackShape;
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
        return DEFAULT_SHP;
    }

    public CircleShape getAttackShape(boolean playerFacingRight) {
        if (playerFacingRight) return R_ATTACK_SHP;
        else return L_ATTACK_SHP;
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