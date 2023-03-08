package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Skeleton implements Character {
    private final PolygonShape shape = new PolygonShape(
            -1.53f, -2.43f,
            0.77f, -2.43f,
            1.64f, 2.38f,
            0.68f, 2.38f,
            -1.1f, 0.97f,
            -1.78f, -0.61f,
            -1.58f, -2.39f);
    private final BodyImage image = new BodyImage(
            "assets/Skeleton/GIFS/Idle.gif", 4.8f);
    private static final float RUNNING_SPEED = 5;
    private static final float JUMPING_SPEED = 5;

    @Override
    public PolygonShape getShape() {
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