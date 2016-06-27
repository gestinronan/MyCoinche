package com.rgestin.coinchecounter.exposed.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.exposed.adapter.view.PartieView;
import com.rgestin.coinchecounter.exposed.adapter.view.PartieView_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronan GESTIN on 27/06/2016.
 */
@EBean
public class PartieAdapter extends BaseAdapter {

    @RootContext
    protected Context context;

    List<Partie> mPartieList = new ArrayList<>();

    @AfterInject
    void initData() {
        mPartieList = new ArrayList<>();
    }

    public void setData(List<Partie> parties){
        mPartieList = parties;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mPartieList.size();
    }

    @Override
    public Partie getItem(final int position) {
        return mPartieList.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View view, final ViewGroup viewGroup) {
        PartieView partieView;

        if (view == null) {
            partieView = PartieView_.build(context);
        } else {
            partieView = (PartieView) view;
        }

        partieView.bind(getItem(position));
        return partieView;
    }
}
