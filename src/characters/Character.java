package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import player.Player;

public abstract class Character {
    private Player player;
    private final PolygonShape
            DEFAULT_SHP,
            L_ATTACK_SHP,
            R_ATTACK_SHP;
    private final BodyImage
            L_IDLE_IMG,
            R_IDLE_IMG,
            L_JUMP_IMG,
            R_JUMP_IMG,
            L_RUN_IMG,
            R_RUN_IMG,
            L_ATTACK_IMG,
            R_ATTACK_IMG;
    private final float
            RUN_SPEED,
            JUMP_SPEED;
    private final int
            ATTACK_DUR,
            ATTACK_DMG;

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

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PolygonShape getDefaultShape() {
        return DEFAULT_SHP;
    }

    public PolygonShape getAttackShape() {
        if (player.isFacingRight()) return R_ATTACK_SHP;
        else return L_ATTACK_SHP;
    }

    public BodyImage getIdleImage() {
        if (player.isFacingRight()) return R_IDLE_IMG;
        else return L_IDLE_IMG;
    }

    public BodyImage getJumpImage() {
        if (player.isFacingRight()) return R_JUMP_IMG;
        else return L_JUMP_IMG;
    }

    public BodyImage getRunImage() {
        if (player.isFacingRight()) return R_RUN_IMG;
        else return L_RUN_IMG;
    }

    public BodyImage getAttackImage() {
        if (player.isFacingRight()) return R_ATTACK_IMG;
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