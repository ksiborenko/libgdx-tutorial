package com.mygdx.tests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {

    ShapeRenderer shape;
    Ball ball;
    Pad pad;
    ArrayList<Brick> bricks;


    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(15, 15, 5, 13);
        pad = new Pad(200, 15, 100, 15);
        bricks = new ArrayList<>();
        int brickHeight = 18;
        int brickWidth = 64;
        for (int i = Gdx.graphics.getHeight() / 2 + brickHeight; i < Gdx.graphics.getHeight(); i += brickHeight + 10) {
            for (int j = 10; j < Gdx.graphics.getWidth() - 10; j += brickWidth + 10) {
                bricks.add(new Brick(j, i, brickWidth, brickHeight));
            }
        }
    }


    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ball.update();
        pad.update();
        ball.collisionCheck(pad);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.render(shape);
        for (Brick brick : bricks) {
            brick.render(shape);
            ball.collisionCheck(brick);
        }
        for (int i = 0; i < bricks.size(); i++) {
            Brick b = bricks.get(i);
            if (b.isDestroyed()) {
                bricks.remove(b);
            }
        }
        pad.render(shape);
        shape.end();

    }


    @Override
    public void dispose() {
        shape.dispose();
    }
}