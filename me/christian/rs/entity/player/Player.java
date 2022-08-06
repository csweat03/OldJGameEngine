package me.christian.rs.entity.player;

import me.christian.rs.entity.Entity;
import me.christian.rs.render.Renderer;
import me.christian.rs.util.*;

import java.awt.*;
import java.util.Random;

public class Player extends Entity {

    private int mass = 10;

    public Player(String name) {
        super(
                name,
                new Random().nextInt((int) (Util.windowWidth - 30)),
                new Random().nextInt((int) (Util.windowHeight - 30)),
                new BoundingBox(10, 10), new Skin(""));
    }

    public void render(Renderer renderer) {
        renderer.drawCircle(getPosX(), Util.windowHeight - getBoundingBox().getHeight() - getPosY(), mass, Color.RED.getRGB());
    }

    public void update(Renderer renderer) {
        super.update(renderer);

        boolean left = Keyboard.isKeyDown(Keyboard.KEY_A);
        boolean right = Keyboard.isKeyDown(Keyboard.KEY_D);
        boolean up = Keyboard.isKeyDown(Keyboard.KEY_W);
        boolean down = Keyboard.isKeyDown(Keyboard.KEY_S);

        float velocity = 0.02F;
        float moveSpeed = (2F + velocity) - (mass / 1000.0F);

        if (left && right) setMotionX(0);
        else if (left && getMotionX() > -moveSpeed + velocity) setMotionX(getMotionX() - velocity);
        else if (right && getMotionX() < moveSpeed - velocity) setMotionX(getMotionX() + velocity);

        if (up && down) setMotionY(0);
        else if (up && getMotionY() < moveSpeed - velocity) setMotionY(getMotionY() + velocity);
        else if (down && getMotionY() > -moveSpeed + velocity) setMotionY(getMotionY() - velocity);

        setMotionX(getMotionX() * 0.98F);
        setMotionY(getMotionY() * 0.98F);

        updateMass(mass);
    }

    private void updateMass(int score) {
        BoundingBox box = new BoundingBox(score, score);

        setBoundingBox(box);
    }
}
