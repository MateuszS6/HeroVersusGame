package world;

import city.cs.engine.CircleShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

import java.awt.*;

public class HealthRefill extends StaticBody {
    public HealthRefill(World w, float x, float y) {
        super(w, new CircleShape(0.5f, x, y));
        this.setFillColor(Color.BLUE);
        this.setLineColor(new Color(0, true));
    }
}
