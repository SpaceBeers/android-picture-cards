package runningpunchdevelopment.babytalk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import runningpunchdevelopment.babytalk.Card;
import runningpunchdevelopment.babytalk.R;
import runningpunchdevelopment.babytalk.adapters.CardAdapter;

public class CategoryListingActivity extends AppCompatActivity {
    private List<Card> cards = new ArrayList<Card>();
    private GridView cardsGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_listing);

        cardsGridView = (GridView)findViewById(R.id.cardsGridView);

        cards.add(new Card("Dog", R.drawable.dog, R.raw.dog));
        cards.add(new Card("Cow", R.drawable.cow, R.raw.cow));
        cards.add(new Card("Coyote", R.drawable.coyote, R.raw.coyote));
        cards.add(new Card("Monkey", R.drawable.monkey, R.raw.monkey));
        cards.add(new Card("Donkey", R.drawable.donkey, R.raw.donkey));
        cards.add(new Card("Elephant", R.drawable.elephant, R.raw.elephant));
        cards.add(new Card("Dolphin", R.drawable.dolphin, R.raw.dolphin));
        cards.add(new Card("Bat", R.drawable.bat, R.raw.bat));
        cards.add(new Card("Chipmunk", R.drawable.chipmunk, R.raw.chipmunk));
        cards.add(new Card("Goose", R.drawable.goose, R.raw.goose));
        cards.add(new Card("Tiger", R.drawable.tiger, R.raw.tiger));
        cards.add(new Card("Zebra", R.drawable.zebra, R.raw.zebra));

        CardAdapter adapter = new CardAdapter(this,R.layout.card_layout, cards);

        cardsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Intent cardDetailIntent = new Intent(CategoryListingActivity.this, CardDetailActivity.class);
                cardDetailIntent.putExtra("Card", cards.get(position));

                startActivityForResult(cardDetailIntent, 1);

                overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_translate);
            }
        });

        cardsGridView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category_listing, menu);
        return true;
    }
}
