package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public interface Character {
    PolygonShape getShape();
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
}