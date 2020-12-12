/*
 * This software is available under Apache License
 * Copyright (c) 2020
 */

package pixel.physics.handler;

import pixel.physics.CollisionGroup;
import pixel.physics.shape.Polygon;

public class PolygonCollisionHandler implements CollisionHandler {

    @Override
    public boolean canHandle(CollisionGroup group) {
        // are the shape of both bodies a circle?
        return group.getA().getShape() instanceof Polygon &&
                group.getB().getShape() instanceof Polygon;
    }

    @Override
    public void handleCollision(CollisionGroup group) {
        // todo: do this
    }
}
