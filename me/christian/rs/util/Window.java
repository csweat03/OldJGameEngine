package me.christian.rs.util;

import me.christian.rs.RunningSim;
import me.christian.rs.render.Renderer;

import javax.swing.*;
import java.awt.*;

public class Window {

    private JFrame frame;

    private String title;
    private int width, height;

    private TestPane pane;

    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        setFrame();
    }

    public void setFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new TestPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class TestPane extends JPanel {

        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Util.windowHeight = frame.getBounds().height - 48;
            Util.windowWidth = frame.getBounds().width;
            RunningSim.INSTANCE.render(new Renderer((Graphics2D) g));
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setTitle(String title) {
        this.title = title;
        frame.setTitle(title);
    }

}
