package world;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody {
    public Platform(World w, float halfWidth, float halfHeight, float x, float y) {
        super(w);
        setPosition(new Vec2(x, y));
        SolidFixture surface = new SolidFixture(this, new BoxShape(halfWidth, halfHeight));
        surface.setFriction(70);
    }
}
