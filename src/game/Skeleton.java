package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Skeleton implements Character {
    private final PolygonShape shape = new PolygonShape(
            -1.23f, -2.02f,
            -0.12f, -2.02f,
            0.78f, -0.46f,
            -0.03f, 1.13f,
            -0.84f, 1.13f,
            -1.62f, -0.58f,
            -1.32f, -1.9f);
    private final BodyImage image = new BodyImage(
            "assets/Skeleton/GIFS/Idle2.gif", 10);
    private static final float RUNNING_SPEED = 5;
    private static final float JUMPING_SPEED = 10;

    @Override
    public PolygonShape getShape() {
        return shape;
    }

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
}