package com.rgestin.coinchecounter.exposed.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.rgestin.coinchecounter.R;
import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.exposed.adapter.PartieAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronan GESTIN on 27/06/2016.
 */
@EActivity(R.layout.activity_list_partie)
public class ListPartieActivity extends AppCompatActivity {

    @ViewById(R.id.list_partie)
    ListView mListPartie;

    @Bean
    PartieAdapter mPartieAdapter;


    @AfterViews
    void afterView(){
       initParties();
    }

    @Background
     void initParties() {
        //TODO GETListPARTIE
        List<Partie> parties = new ArrayList<>();
        initAdapter(parties);
    }

    @UiThread
     void initAdapter(final List<Partie> parties) {
        mPartieAdapter.setData(parties);
        mListPartie.setAdapter(mPartieAdapter);
    }

    @Click(R.id.nouvelle_partie)
    void nouvellePartie(){

    }

    @ItemClick(R.id.list_partie)
    void startScoreView(Partie partieChoose){
        ScoreActivity_.intent(this)
                .mPartie(partieChoose)
                .start();
    }
}
