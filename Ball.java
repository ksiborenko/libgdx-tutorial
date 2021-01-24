package com.mygdx.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.security.Key;

public class Ball extends Shape {

    private final int size;
    Color color = Color.WHITE;

    public Ball(int x, int y, int speed, int size) {
        super(x, y);
        this.xSpeed = ySpeed = speed;
        this.size = size;
    }

    @Override
    public void render(ShapeRenderer shape) {
        shape.circle(x, y, size);
        shape.setColor(color);
    }

    @Override
    public void update() {
        super.update();
        if (this.x < this.size || this.x > Gdx.graphics.getWidth() - this.size) {
            this.xSpeed = -this.xSpeed;
        }
        if (this.y < this.size || this.y > Gdx.graphics.getHeight() - this.size) {
            this.ySpeed = -this.ySpeed;
        }
    }

    public void collisionCheck(Pad pad) {
        if (collisionDetection(pad)) {
            this.ySpeed = -this.ySpeed;
        }
    }

    private boolean collisionDetection(Pad pad) {
        return this.x + this.size >= pad.getX() &&
                this.x - this.size <= pad.getX() + pad.getWidth() &&
                this.y + this.size >= pad.getY() &&
                this.y - this.size <= pad.getY() + pad.getHeight();
    }

    public void collisionCheck(Brick brick) {
        if (collisionDetection(brick)) {
            this.ySpeed = -this.ySpeed;
            brick.setDestroyed(true);
        }
    }

    private boolean collisionDetection(Brick brick) {
        return this.x + this.size >= brick.getX() &&
                this.x - this.size <= brick.getX() + brick.getWidth() &&
                this.y + this.size >= brick.getY() &&
                this.y - this.size <= brick.getY() + brick.getHeight();
    }
}
