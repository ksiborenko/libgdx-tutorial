package com.mygdx.tests;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Shape {

    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;
    protected int width;
    protected int height;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void render(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }

    public void update() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }
}
