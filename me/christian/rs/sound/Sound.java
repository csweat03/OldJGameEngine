package me.christian.rs.sound;

import me.christian.rs.util.Util;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.net.URL;

public class Sound {
    private String urlOrPath;

    private boolean loop = false;
    private float volume = 6.0206F;
    private int repeatCount = 0;

    public Sound(String urlOrPath) {
        this.urlOrPath = urlOrPath;
    }

    public void play() {
        try {
            boolean url = urlOrPath.contains("http") && urlOrPath.contains("://");

            AudioInputStream ais;

            if (url) {
                ais = AudioSystem.getAudioInputStream(new URL(urlOrPath));
            } else {
                ais = AudioSystem.getAudioInputStream(new File("assets\\sounds\\" + urlOrPath).getAbsoluteFile());
            }

            Clip clip = AudioSystem.getClip();
            clip.open(ais);

            if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.loop(repeatCount);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Sound volume(int volume) {
        this.volume = volume;
        return this;
    }

    public Sound repeat(int count) {
        this.repeatCount = count;
        return this;
    }

    public Sound loop() {
        this.loop = true;
        return this;
    }
}
