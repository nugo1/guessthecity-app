package me.montecode.pmcg.kvizoprirodi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stevyhacker on 24.11.14..
 */
public class AdapterForHighScoreList extends ArrayAdapter<ScoreItem>{

    private Context context;
    private ArrayList<ScoreItem> highScoreValues;

    public AdapterForHighScoreList(Context context, ArrayList<ScoreItem> highScoreValues) {
        super(context, R.layout.high_score_list_item_layout,highScoreValues);
        this.highScoreValues = highScoreValues;
        this.context = context;
    }

    @Override
    public int getCount(){
        return highScoreValues.size();
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.high_score_list_item_layout, parent, false);

        ScoreItem score = highScoreValues.get(position);

        TextView scoreNameTextView = (TextView) view.findViewById(R.id.scoreNameTextView);
        TextView scoreResultTextView = (TextView) view.findViewById(R.id.scoreResultTextView);

        scoreNameTextView.setText(score.name);
        scoreResultTextView.setText(score.result);


        return view;

    }

}
