package com.rgestin.coinchecounter.exposed.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.rgestin.coinchecounter.R;
import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.connector.model.Score;
import com.rgestin.coinchecounter.exposed.adapter.ScoreTeamAdapter;
import com.rgestin.coinchecounter.exposed.dialog.AddScoreDialog;
import com.rgestin.coinchecounter.exposed.dialog.AddScoreDialog_;
import com.rgestin.coinchecounter.service.ScoreService;
import com.rgestin.coinchecounter.service.impl.PartieSerivceImpl;
import com.rgestin.coinchecounter.service.impl.ScoreServiceImpl;
import com.rgestin.coinchecounter.service.impl.TeamServiceImpl;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class ScoreActivity extends AppCompatActivity {

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
    @Bean
    ScoreServiceImpl scoreService;
    @Bean
    TeamServiceImpl teamService;
    @Extra
    Partie mPartie;


    @AfterViews
    void afterView(){
        mListViewTeam1.setAdapter(team1Adapter);
        mListViewTeam2.setAdapter(team2Adapter);
    }


    @Click(R.id.addScore)
    void clickAddScore(){
        AddScoreDialog build = AddScoreDialog_.builder()
                .mOnConfirmScoreListener(new AddScoreDialog.OnConfirmScoreListener() {
                                             @Override
                                             public void socre(int team1, int team2) {
                                                 Score score1 = new Score();
                                                 score1.setScoreManche(team1);
                                                 int team1AdapterItem = team1Adapter.getCount()>0?team1Adapter.getItem(team1Adapter.getCount()-1).getScorePartie():0;
                                                 score1.setScorePartie(team1+ team1AdapterItem);
                                                 team1Adapter.setData(score1);

                                                 Score score2 = new Score();
                                                 score2.setScoreManche(team2);
                                                 int team2AdapterItem = team2Adapter.getCount()>0?team2Adapter.getItem(team2Adapter.getCount()-1).getScorePartie():0;
                                                 score2.setScorePartie(team2+ team2AdapterItem);
                                                 team2Adapter.setData(score2);

                                                 team1Adapter.notifyDataSetChanged();
                                                 team2Adapter.notifyDataSetChanged();
                                             }
                                         }
                )
                .build();

        build.show(getSupportFragmentManager(), "ClickAddScore");

    }
}
