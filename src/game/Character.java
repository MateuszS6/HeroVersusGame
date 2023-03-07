package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public interface Character {
    PolygonShape getShape();
    BodyImage getImage();
    float getRunningSpeed();
    float getJumpingSpeed();
    void attack();
}