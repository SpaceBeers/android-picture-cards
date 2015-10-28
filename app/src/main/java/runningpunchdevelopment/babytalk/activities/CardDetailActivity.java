package runningpunchdevelopment.babytalk.activities;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import runningpunchdevelopment.babytalk.Card;
import runningpunchdevelopment.babytalk.R;

public class CardDetailActivity extends AppCompatActivity {
    private SoundPool spool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);

        final TextView cardNameView = (TextView)findViewById(R.id.cardNameView);
        final ImageView cardImageView = (ImageView)findViewById(R.id.cardImageView);

        Serializable extra = getIntent().getSerializableExtra("Card");

        if (extra != null) {
            Card card = (Card)extra;
            cardNameView.setText(card.getName());
            cardImageView.setImageResource(card.getImage());

            spool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
            int soundID = spool.load(this, card.getSound(), 1);
            spool.play(soundID, 500, 500, 1, 0, 1f);

            /*MediaPlayer player = MediaPlayer.create(this.getContext(), card.getSound());
            player.setWakeMode(getApplicationContext()PowerManager.PARTIAL_WAKE_LOCK);
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setOnPreparedListener(this);
            player.setOnCompletionListener(this);
            player.setOnErrorListener(this);
            try {
                player.prepare();
                player.start();
                Log.e("debug", "sound played");
            }  catch(Exception e) {}
            player.stop();*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_detail, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
