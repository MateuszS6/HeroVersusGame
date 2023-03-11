package game;

import city.cs.engine.BoxShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody {
    public Platform(World world, float halfWidth, float halfHeight, float x, float y) {
        super(world, new BoxShape(halfWidth, halfHeight));
        setPosition(new Vec2(x, y));
        SolidFixture surface = new SolidFixture(this, new BoxShape(halfWidth, halfHeight));
        surface.setFriction(70);
    }
}
