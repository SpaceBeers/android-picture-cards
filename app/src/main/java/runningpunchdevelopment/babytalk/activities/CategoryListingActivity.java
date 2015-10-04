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

        Card cards_array[] = new Card[]
            {
                    new Card("Matt", R.drawable.sample_0),
                    new Card("Dog", R.drawable.sample_1),
                    new Card("Carl", R.drawable.sample_2),
                    new Card("Jeff", R.drawable.sample_3),
                    new Card("Cow", R.drawable.sample_4),
                    new Card("Cow", R.drawable.sample_5),
                    new Card("Cow", R.drawable.sample_6),
                    new Card("Cow", R.drawable.sample_7)
            };

        CardAdapter adapter = new CardAdapter(this,R.layout.card_layout, cards_array);

        cardsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Intent cardDetailIntent = new Intent(view.getContext(), CardDetailActivity.class);
                //editNoteIntent.putExtra("Note", notes.get(position));

                startActivityForResult(cardDetailIntent, 1);
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
