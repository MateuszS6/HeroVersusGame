package game;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HoveringPlatform extends DynamicBody implements ActionListener {
    public HoveringPlatform(World world, float halfWidth, float halfHeight, float x, float y) {
        super(world, new BoxShape(halfWidth, halfHeight));
        setPosition(new Vec2(x, y));
        setGravityScale(0);
        SolidFixture surface = new SolidFixture(this, new BoxShape(halfWidth, halfHeight));
        surface.setFriction(70);
    }

    public void hover() {
        Timer timer = new Timer(1000, this);
        // timer.setInitialDelay(5000);
        timer.start();
        setLinearVelocity(new Vec2(0, -1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setLinearVelocity(new Vec2(0, -getLinearVelocity().y));
    }
}
