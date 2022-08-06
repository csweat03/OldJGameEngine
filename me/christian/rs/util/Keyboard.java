package me.christian.rs.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Keyboard implements KeyListener {

    public static final int KEY_NONE = 0, KEY_SHIFT = 16, KEY_CTRL = 17, KEY_ALT = 18, KEY_SPACE = 32,
            KEY_A = 65, KEY_B = 66, KEY_C = 67, KEY_D = 68, KEY_E = 69, KEY_F = 70,
            KEY_G = 71, KEY_H = 72, KEY_I = 73, KEY_J = 74, KEY_K = 75, KEY_L = 76,
            KEY_M = 77, KEY_N = 78, KEY_O = 79, KEY_P = 80, KEY_Q = 81, KEY_R = 82,
            KEY_S = 83, KEY_T = 84, KEY_U = 85, KEY_V = 86, KEY_W = 87, KEY_X = 88,
            KEY_Y = 89, KEY_Z = 90;

    private static List<Integer> pressedArray = new ArrayList<>();

    public static boolean isKeyDown(int key) {
        return pressedArray.contains(key);
    }

    public static List<Integer> getKeysDown() {
        return pressedArray;
    }

    private static void set(int pressed) {
        if (!Keyboard.pressedArray.contains(pressed))
            Keyboard.pressedArray.add(pressed);
    }

    public void keyPressed(KeyEvent e) {
        set(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        Keyboard.pressedArray.remove((Integer) e.getKeyCode());
    }

}