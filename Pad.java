package com.mygdx.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Pad extends Shape {


    public Pad(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(ShapeRenderer shape) {
        super.render(shape);
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.x += 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.x -= 5;
        }
        if (this.x <= 0) {
            this.x = 0;
        }
        if (this.x >= Gdx.graphics.getWidth() - this.width) {
            this.x = Gdx.graphics.getWidth() - this.width;
        }
    }
}
