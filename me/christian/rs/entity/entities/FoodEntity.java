package me.christian.rs.entity.entities;

import me.christian.rs.entity.Entity;
import me.christian.rs.render.Renderer;
import me.christian.rs.util.BoundingBox;
import me.christian.rs.util.Skin;
import me.christian.rs.util.Util;

import java.awt.*;
import java.util.Random;

public class FoodEntity extends Entity {

    public FoodEntity() {
        super("Food",
                new Random().nextInt((int) (Util.windowWidth - 30)),
                new Random().nextInt((int) (Util.windowHeight - 30)),
                new BoundingBox(6,6), new Skin(""));
    }

    public void render(Renderer renderer) {
        renderer.drawCircle(getPosX(), Util.windowHeight - getBoundingBox().getHeight() - getPosY(), 6, Color.GREEN.getRGB());
    }

    public void update(Renderer renderer) {
        super.update(renderer);


    }
}
