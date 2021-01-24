package com.mygdx.tests;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick extends Shape {

    private boolean destroyed = false;

    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void render(ShapeRenderer shape) {
        super.render(shape);
    }
}
