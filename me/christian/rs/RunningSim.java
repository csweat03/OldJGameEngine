package me.christian.rs;

import me.christian.rs.entity.Entity;
import me.christian.rs.entity.entities.FoodEntity;
import me.christian.rs.entity.player.Player;
import me.christian.rs.render.Renderer;
import me.christian.rs.sound.Sound;
import me.christian.rs.util.Keyboard;
import me.christian.rs.util.Timer;
import me.christian.rs.util.Window;

import java.util.ArrayList;
import java.util.List;

public enum RunningSim {
    INSTANCE;

    public static int fpsCap = 120;
    private boolean running = false;

    private Timer timer0 = new Timer();

    public static List<Entity> entities = new ArrayList<>();

    private Window window;

    public void init() throws Exception {
        running = true;

        window = new Window("Running Simulation", 1080, 720);

        new Sound("backgroundMusic.wav").volume(-15).loop().play();

        window.getFrame().addKeyListener(new Keyboard());
        new Player("bob");

        new FoodEntity();

        while (running) {
            if (timer0.hasTimeElapsed(1000 / fpsCap)) {
                tick();
                window.getFrame().getComponent(0).revalidate();
                window.getFrame().getComponent(0).repaint();

                timer0.resetClocks();
            }
        }
        running = false;
    }

    public void tick() {
    }

    public void render(Renderer renderer) {
        entities.forEach(entity -> entity.update(renderer));
    }




}
