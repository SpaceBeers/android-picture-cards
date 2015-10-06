package runningpunchdevelopment.babytalk;

import android.media.AudioManager;
import android.media.SoundPool;

import java.io.Serializable;

/**
 * Created by vhmit007 on 30/09/15.
 */
public class Card implements Serializable {
    private String name;
    private int image;
    private int sound;

    public Card(String name, int image, int sound) {
        this.name = name;

        this.image = image;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}