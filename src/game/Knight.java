package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Knight implements Character {
    private final PolygonShape shape = new PolygonShape(
            -0.58f, -0.19f,
            -0.05f, -0.19f,
            0.41f, -1.73f,
            0.25f, -3.03f,
            -0.97f, -3.05f,
            -1.21f, -1.73f,
            -0.65f, -0.31f);
    private final BodyImage image = new BodyImage(
            "assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 6);
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