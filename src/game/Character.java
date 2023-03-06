package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;

public interface Character {
    BoxShape getShape();
    BodyImage getImage();
    void attack();
}