package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;

public class Knight implements Character {
    private final BoxShape shape = new BoxShape(1, 2);
    private final BodyImage image = new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 4);

    @Override
    public BoxShape getShape() {
        return shape;
    }

    @Override
    public BodyImage getImage() {
        return image;
    }

    @Override
    public void attack() {
    }
}