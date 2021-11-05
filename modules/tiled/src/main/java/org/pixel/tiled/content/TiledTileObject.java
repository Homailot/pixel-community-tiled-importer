package org.pixel.tiled.content;

import org.pixel.tiled.view.GenericObjectLayerView;

public class TiledTileObject extends TiledObject {
    private long gID;
    private double height;
    private double width;

    public long getgID() {
        return gID;
    }

    public void setgID(long gID) {
        this.gID = gID;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void draw(TiledObjectGroup group, GenericObjectLayerView view) {
        view.draw(this, group);
    }
}
