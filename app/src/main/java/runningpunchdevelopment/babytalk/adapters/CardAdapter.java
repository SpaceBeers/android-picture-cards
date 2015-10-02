package runningpunchdevelopment.babytalk.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import runningpunchdevelopment.babytalk.Card;
import runningpunchdevelopment.babytalk.R;

public class CardAdapter extends ArrayAdapter<Card> {

    Context context;
    int layoutResourceId;
    Card data[] = null;

    public CardAdapter(Context context, int layoutResourceId, Card[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CardHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new CardHolder();
            holder.cardTitle = (TextView) row.findViewById(R.id.cardTextView);
            //holder.cardImage = (ImageView) row.findViewById(R.id.cardImageView);

            row.setTag(holder);
        } else {
            holder = (CardHolder)row.getTag();
        }

        Card card = data[position];
        holder.cardTitle.setText(card.getName());
        //holder.cardImage.setImageResource(card.getImage());

        return row;
    }

    static class CardHolder
    {
        ImageView cardImage;
        TextView cardTitle;
    }
}