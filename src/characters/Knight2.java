package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Knight2 implements Character {
    
    @Override
    public PolygonShape getDefaultShape() {
        return null;
    }

    @Override
    public PolygonShape getAttackShape(boolean playerFacingRight) {
        return null;
    }

    @Override
    public BodyImage getIdleImage(boolean playerFacingRight) {
        return null;
    }

    @Override
    public BodyImage getJumpingImage(boolean playerFacingRight) {
        return null;
    }

    @Override
    public BodyImage getRunningImage(boolean playerFacingRight) {
        return null;
    }

    @Override
    public BodyImage getAttackImage(boolean playerFacingRight) {
        return null;
    }

    @Override
    public float getRunningSpeed() {
        return 0;
    }

    @Override
    public float getJumpingSpeed() {
        return 0;
    }

    @Override
    public int getAttackDuration() {
        return 0;
    }

    @Override
    public int getAttackDamage() {
        return 0;
    }
}
