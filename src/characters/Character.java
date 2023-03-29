package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public interface Character {
    PolygonShape getDefaultShape();

    PolygonShape getAttackShape(boolean playerFacingRight);

    BodyImage getIdleImage(boolean playerFacingRight);

    BodyImage getJumpingImage(boolean playerFacingRight);

    BodyImage getRunningImage(boolean playerFacingRight);

    BodyImage getAttackImage(boolean playerFacingRight);

    float getRunningSpeed();

    float getJumpingSpeed();

    int getAttackDuration();

    int getAttackDamage();
}