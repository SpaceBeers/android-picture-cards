package runningpunchdevelopment.babytalk;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.io.Serializable;

/**
 * Created by vhmit007 on 30/09/15.
 */
public class Card implements Serializable {
    private String name;
    private int image;

    public Card(String name, int image) {
        this.image = image;
        this.name = name;
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
}