package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Knight implements Character {
    private final PolygonShape shape = new PolygonShape(
            -1.3f, -4.04f,
            0.31f, -4.04f,
            0.46f, -2.29f,
            -0.1f, -0.32f,
            -0.7f, -0.32f,
            -1.63f, -2.22f,
            -1.34f, -3.94f);
    private final BodyImage image = new BodyImage(
            "assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 8);
    private static final float RUNNING_SPEED = 5;
    private static final float JUMPING_SPEED = 10;

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