package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Knight implements Character {
    private final PolygonShape shape = new PolygonShape(-0.35f,-0.16f, -0.02f,-0.16f, 0.23f,-1.14f, 0.14f,-2.0f, -0.66f,-2.0f, -0.82f,-1.1f, -0.41f,-0.2f);
    private final BodyImage image = new BodyImage("assets/FreeKnight/Colour1/NoOutline/120x80_gifs/__Idle.gif", 4);
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