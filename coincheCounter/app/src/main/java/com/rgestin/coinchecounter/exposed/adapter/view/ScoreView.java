package com.rgestin.coinchecounter.exposed.adapter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rgestin.coinchecounter.R;
import com.rgestin.coinchecounter.connector.Score;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Ronan GESTIN on 24/06/2016.
 */
@EViewGroup(R.layout.view_score)
public class ScoreView extends LinearLayout{

    @ViewById(R.id.scoreText)
    TextView scoreTV;

    public ScoreView(final Context context) {
        super(context);
    }


    public void bind(@NonNull final Score score) {
        scoreTV.setText();
    }
}