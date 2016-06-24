package com.rgestin.coinchecounter.exposed.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rgestin.coinchecounter.connector.Score;
import com.rgestin.coinchecounter.exposed.adapter.view.ScoreView;

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


    public void setDatas(final List<Score> scoreList) {
        mScoreList = scoreList;
    }

    @Override
    public int getCount() {
        return mScoreList.size();
    }

    @Override
    public Object getItem(final int i) {
        return mScoreList.get(i);
    }

    @Override
    public long getItemId(final int i) {
        return i;
    }

    @Override
    public View getView(final int i, final View view, final ViewGroup viewGroup) {
        ScoreView
        return null;
    }
}
