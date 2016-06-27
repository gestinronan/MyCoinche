package com.rgestin.coinchecounter.exposed.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.rgestin.coinchecounter.R;
import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.exposed.adapter.PartieAdapter;
import com.rgestin.coinchecounter.exposed.dialog.PartieScoreDialog;
import com.rgestin.coinchecounter.exposed.dialog.PartieScoreDialog_;
import com.rgestin.coinchecounter.service.impl.PartieSerivceImpl;

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
    @Bean
    PartieSerivceImpl partieSerivce;


    @AfterViews
    void afterView(){
       initParties();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initParties();
    }

    @Background
     void initParties() {
        List<Partie> parties = partieSerivce.getAllPartie();
        initAdapter(parties);
    }

    @UiThread
     void initAdapter(final List<Partie> parties) {
        mPartieAdapter.setData(parties);
        mListPartie.setAdapter(mPartieAdapter);
    }

    @Click(R.id.nouvelle_partie)
    void nouvellePartie(){
        PartieScoreDialog build = PartieScoreDialog_.builder()
                .onConfirmPartieListener(new PartieScoreDialog.OnConfirmPartieListener() {
                    @Override
                    public void partie(String name) {
                        Partie createpratie = partieSerivce.createpratie(name);
                        if(createpratie != null){
                            ScoreActivity_.intent(ListPartieActivity.this)
                                    .mPartie(createpratie)
                                    .start();
                        }else{
                            Toast.makeText(ListPartieActivity.this, "Erreur lors de la creations de la partie", Toast.LENGTH_LONG).show();
                        }
                    }
                }).build();
        build.show(getSupportFragmentManager(), "partie");

    }

    @ItemClick(R.id.list_partie)
    void startScoreView(Partie partieChoose){
        ScoreActivity_.intent(this)
                .mPartie(partieChoose)
                .start();
    }
}
