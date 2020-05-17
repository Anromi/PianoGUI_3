package sample;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Music {

    private String track; // адресс файла
    private Clip m = null;

    // конструктор
    public Music(String track) {
        this.track = track;
    }

    public void sound() {

        File dirT = new File(new File(this.track).getAbsolutePath());
        File a = new File(this.track);
        AudioInputStream audioInputStream = null;

        try {
            audioInputStream = AudioSystem.getAudioInputStream(dirT);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }

        try {
            m = AudioSystem.getClip();
            m.open(audioInputStream);
            m.setFramePosition(0);
            m.start();
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}