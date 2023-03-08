package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;

public class Skeleton implements Character {
    private final PolygonShape shape = new PolygonShape(
            -1.48f,-2.42f, 0.18f,-2.39f, 1.08f,-0.52f, 0.04f,1.68f, -1.08f,1.14f, -1.76f,-0.66f, -1.55f,-2.24f);
    private final BodyImage image = new BodyImage(
            "assets/Skeleton/GIFS/Idle2.gif", 12);
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