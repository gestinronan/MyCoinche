package com.rgestin.coinchecounter.exposed.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.dao.ForeignCollection;
import com.rgestin.coinchecounter.R;
import com.rgestin.coinchecounter.business.service.impl.PartieSerivceImpl;
import com.rgestin.coinchecounter.business.service.impl.ScoreServiceImpl;
import com.rgestin.coinchecounter.business.service.impl.TeamServiceImpl;
import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.connector.model.Score;
import com.rgestin.coinchecounter.connector.model.Team;
import com.rgestin.coinchecounter.exposed.adapter.ScoreTeamAdapter;
import com.rgestin.coinchecounter.exposed.dialog.AddScoreDialog;
import com.rgestin.coinchecounter.exposed.dialog.AddScoreDialog_;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class ScoreActivity extends AppCompatActivity {

    @ViewById(R.id.scoreTeam1)
    ListView mListViewTeam1;
    @ViewById(R.id.scoreTeam2)
    ListView mListViewTeam2;
    @ViewById(R.id.team2_name_tv)
    TextView nameTeam2;
    @ViewById(R.id.team1_name_tv)
    TextView nameTeam1;
    @ViewById(R.id.team1_score_tv)
    TextView scoreTeam1;
    @ViewById(R.id.team2_score_tv)
    TextView scoreTeam2;
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
    @Bean
    PartieSerivceImpl mPartieSerivce;
    @Extra
    Long mPartieId;
    private Team mTeam1;
    private Team mTeam2;
    private Partie mPartie;


    @AfterExtras
    void afterExtra() {
        mPartie = mPartieSerivce.getPartie(mPartieId);
        if (mPartie != null) {
            mPartieSerivce.updatePartie(mPartie);

            ForeignCollection<Team> teams = mPartie.getTeams();
            List<Team> teamList = new ArrayList<>(teams);
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    mTeam1 = teamList.get(i);
                    team1Adapter.setDatas(new ArrayList<>(mTeam1.getScores()));
                }
                if (i == 1) {
                    mTeam2 = teamList.get(i);
                    team2Adapter.setDatas(new ArrayList<>(mTeam2.getScores()));
                }

            }

        }

    }

    @AfterViews
     void afterView() {
        mListViewTeam1.setAdapter(team1Adapter);
        mListViewTeam2.setAdapter(team2Adapter);
        nameTeam1.setText(mTeam1.getName());
        nameTeam2.setText(mTeam2.getName());
        scoreTeam1.setText(team1Adapter.getCount()>0 ? team1Adapter.getItem(team1Adapter.getCount() -1).getScorePartie()+"" : 0+"");
        scoreTeam2.setText(team2Adapter.getCount()>0 ? team2Adapter.getItem(team2Adapter.getCount() -1).getScorePartie()+"" : 0+"");
    }


    @Click(R.id.addScore)
    void clickAddScore() {
        AddScoreDialog build = AddScoreDialog_.builder()
                .mOnConfirmScoreListener(new AddScoreDialog.OnConfirmScoreListener() {
                                             @Override
                                             public void socre(int team1, int team2) {


                                                 int team1AdapterItem = team1Adapter.getCount() > 0 ? team1Adapter.getItem(team1Adapter.getCount() - 1).getScorePartie() : 0;
                                                 Score score1 = scoreService.createScore(team1, team1AdapterItem+team1, mTeam1);
                                                 team1Adapter.setData(score1);

                                                 int team2AdapterItem = team2Adapter.getCount() > 0 ? team2Adapter.getItem(team2Adapter.getCount() - 1).getScorePartie() : 0;
                                                 Score score2 = scoreService.createScore(team2, team2AdapterItem+team2, mTeam2);
                                                 team2Adapter.setData(score2);

                                                 team1Adapter.notifyDataSetChanged();
                                                 team2Adapter.notifyDataSetChanged();
                                                 scoreTeam1.setText(team1Adapter.getCount()>0 ? team1Adapter.getItem(team1Adapter.getCount() -1).getScorePartie()+"" : 0+"");
                                                 scoreTeam2.setText(team2Adapter.getCount()>0 ? team2Adapter.getItem(team2Adapter.getCount() -1).getScorePartie()+"" : 0+"");
                                                                                              }
                                         }
                )
                .build();

        build.show(getSupportFragmentManager(), "ClickAddScore");

    }
}
