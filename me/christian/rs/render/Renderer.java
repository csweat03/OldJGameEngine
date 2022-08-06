package me.christian.rs.render;

import javax.swing.border.StrokeBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Renderer {

    private final Graphics2D graphics;

    public Renderer(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public void drawPoint(double x, double y, int color) {
        color(color);
        graphics.drawRect((int)x, (int)y, 1, 1);
    }

    public void drawCircle(double x, double y, int size, int color) {
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Shape s = new Ellipse2D.Double((int)x, (int)y, size, size);

        graphics.setStroke(new BasicStroke(0));
        graphics.draw(s);
        color(color);
        graphics.fill(s);

        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    public void drawRect(double x, double y, double width, double height, int color) {
        for (double X = x; X < x + width; X++)
            for (double Y = y; Y < y + height; Y++)
                drawPoint(X, Y, color);
    }

    public void drawImageRect(double x, double y, double width, double height, Image image) {
        graphics.drawImage(image, (int) x, (int) y, (int) width, (int) height,null);
    }

    public void color(int color) {
        graphics.setColor(new Color(color));
    }

    public void scale(double x, double y) {
        graphics.scale(x, y);
    }

    public void rotate(double degrees) {
        graphics.rotate(Math.toRadians(degrees));
    }

    public void wash() {
        color(0);
        scale(1, 1);
        rotate(0);
    }

}
