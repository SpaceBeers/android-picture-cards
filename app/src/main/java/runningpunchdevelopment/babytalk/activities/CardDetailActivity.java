package runningpunchdevelopment.babytalk.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import runningpunchdevelopment.babytalk.Card;
import runningpunchdevelopment.babytalk.R;

public class CardDetailActivity extends AppCompatActivity {
    MediaPlayer player;

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

            player = MediaPlayer.create(getApplicationContext(), card.getSound());
            player.start();

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer player) {
                    System.out.println("Sound over");
                }
            });
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
