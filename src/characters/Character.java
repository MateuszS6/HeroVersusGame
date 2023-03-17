package characters;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public interface Character {
    PolygonShape getDefaultShape();
    PolygonShape getAttackLeftShape();
    PolygonShape getAttackRightShape();
    BodyImage getIdleLeftImage();
    BodyImage getIdleRightImage();
    BodyImage getJumpingLeftImage();
    BodyImage getJumpingRightImage();
    BodyImage getRunningLeftImage();
    BodyImage getRunningRightImage();
    BodyImage getAttackLeftImage();
    BodyImage getAttackRightImage();
    float getRunningSpeed();
    float getJumpingSpeed();
    int getAttackDuration();
    int getAttackDamage();
}