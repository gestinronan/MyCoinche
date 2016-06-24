package com.rgestin.coinchecounter.exposed.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.rgestin.coinchecounter.R;
import com.rgestin.coinchecounter.exposed.adapter.ScoreTeamAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.scoreTeam1)
    ListView mListViewTeam1;
    @ViewById(R.id.scoreTeam2)
    ListView mListViewTeam2;
    @ViewById(R.id.addScore)
    ImageView mAdd;
    @Bean
    ScoreTeamAdapter team1Adapter;
    @Bean
    ScoreTeamAdapter team2Adapter;


    @AfterViews
    void afterView(){


        //TODO init list

    }


    @Click(R.id.addScore)
    void clickAddScore(){

    }
}