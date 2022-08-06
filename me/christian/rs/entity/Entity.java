package me.christian.rs.entity;

import me.christian.rs.RunningSim;
import me.christian.rs.render.Renderer;
import me.christian.rs.util.BoundingBox;
import me.christian.rs.util.Skin;
import me.christian.rs.util.Util;

public class Entity {

    private String name;
    private BoundingBox boundingBox;
    private Skin skin;
    private double posX, posY;
    private double motionX = 0, motionY = 0;

    public Entity(String name, double posX, double posY, BoundingBox boundingBox, Skin skin) {
        this.name = name;
        this.boundingBox = boundingBox;
        this.skin = skin;
        this.posX = posX;
        this.posY = posY;
        addEntityToWorld();
    }

    public void render(Renderer renderer) {
        renderer.drawImageRect(posX, Util.windowHeight - boundingBox.getHeight() - posY, boundingBox.getWidth(), boundingBox.getHeight(), skin.getSkin());
    }


    public void update(Renderer renderer) {
        render(renderer);

        move(motionX, motionY);
    }

    public String getName() {
        return name;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getMotionX() {
        return motionX;
    }

    public void setMotionX(double motionX) {
        this.motionX = motionX;
    }

    public double getMotionY() {
        return motionY;
    }

    public void setMotionY(double motionY) {
        this.motionY = motionY;
    }

    public void move(double posX, double posY) {
        teleport(this.posX + posX, this.posY + posY);
    }

    public void teleport(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void addEntityToWorld() {
        RunningSim.entities.add(this);
    }

    public boolean legal() {
        return posX >= 0 && posX < Util.windowWidth - boundingBox.getWidth();
    }
}
