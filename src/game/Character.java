package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;

/** Character interface. */
public interface Character {
    BoxShape getShape();
    BodyImage getImage();
    void attack();
}