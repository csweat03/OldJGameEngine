package me.christian.rs.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.URL;

public class Skin {

    private String urlOrPath;

    private Image skin = null;

    public Skin(String urlOrPath) {
        setSkin(urlOrPath);
    }

    public Image getSkin() {
        boolean url = urlOrPath.contains("http") && urlOrPath.contains("://");

        if (skin == null) {
            try {
                if (url) {
                    this.skin = ImageIO.read(new URL(urlOrPath));
                } else {
                    this.skin = ImageIO.read(new File(Util.PATH + "\\assets\\skins\\" + urlOrPath));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return this.skin;

    }

    public void setSkin(String urlOrPath) {
        this.urlOrPath = urlOrPath;
    }
}
