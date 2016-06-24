package com.rgestin.coinchecounter.exposed.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rgestin.coinchecounter.connector.Score;
import com.rgestin.coinchecounter.exposed.adapter.view.ScoreView;
import com.rgestin.coinchecounter.exposed.adapter.view.ScoreView_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronan GESTIN on 24/06/2016.
 */
@EBean
public class ScoreTeamAdapter extends BaseAdapter {

    @RootContext
    protected Context context;

    List<Score> mScoreList = new ArrayList<>();

    @AfterInject
    void initData() {
        mScoreList = new ArrayList<>();
    }


    public void setData(final Score score) {
        mScoreList.add(score);
    }

    @Override
    public int getCount() {
        return mScoreList.size();
    }

    @Override
    public Score getItem(final int position) {
        return mScoreList.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View view, final ViewGroup viewGroup) {
        ScoreView scoreView;

        if (view == null) {
            scoreView = ScoreView_.build(context);
        } else {
            scoreView = (ScoreView) view;
        }

        scoreView.bind(getItem(position));
        return scoreView;
    }
}
