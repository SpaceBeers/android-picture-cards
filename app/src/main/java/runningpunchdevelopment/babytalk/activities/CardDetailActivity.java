package runningpunchdevelopment.babytalk.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import runningpunchdevelopment.babytalk.Card;
import runningpunchdevelopment.babytalk.R;

public class CardDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final TextView cardNameView = (TextView)findViewById(R.id.cardNameView);
        final ImageView cardImageView = (ImageView)findViewById(R.id.cardImageView);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_detail, menu);
        Serializable extra = getIntent().getSerializableExtra("Card");

        if (extra != null) {
            Card card = (Card)extra;
            cardNameView.setText(card.getName());
            cardImageView.setImageResource(card.getImage());
        }

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
