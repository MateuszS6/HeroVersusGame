package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;

public class Skeleton implements Character {
    private final BoxShape shape = new BoxShape(1, 2);
    private final BodyImage image = new BodyImage("", 4);
    private static final float RUNNING_SPEED = 5;
    private static final float JUMPING_SPEED = 5;

    @Override
    public BoxShape getShape() {
        return shape;
    }

    @Override
    public BodyImage getImage() {
        return image;
    }

    @Override
    public float getRunningSpeed() {
        return RUNNING_SPEED;
    }

    @Override
    public float getJumpingSpeed() {
        return JUMPING_SPEED;
    }

    @Override
    public void attack() {
    }
}