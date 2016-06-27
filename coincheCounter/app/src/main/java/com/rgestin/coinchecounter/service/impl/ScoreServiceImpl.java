package com.rgestin.coinchecounter.service.impl;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.rgestin.coinchecounter.connector.DbHelper;
import com.rgestin.coinchecounter.connector.model.Score;
import com.rgestin.coinchecounter.connector.model.Team;
import com.rgestin.coinchecounter.service.ScoreService;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronan GESTIN on 27/06/2016.
 */
@EBean
public class ScoreServiceImpl implements ScoreService {

    private static final String TAG = ScoreServiceImpl.class.getSimpleName();

    @RootContext
    protected Context context;

    @OrmLiteDao(helper = DbHelper.class)
    Dao<Score, Long> scoreLongDao;

    @Override
    public Score createScore(int value, int partie, Team team) {
        Score score = new Score();
        score.setTeam(team);
        score.setScorePartie(partie);
        score.setScoreManche(value);
        try {
            scoreLongDao.create(score);
        } catch (SQLException e) {
            Log.e(TAG, "CREATE SCORE ERROR", e);
            return null;
        }


        return score;
    }

    @Override
    public List<Score> getAllForTeam(Team team) {
        try {
           return scoreLongDao.queryBuilder().where().eq(Score.TABLE_SCORE_TEAM, team).query();
        } catch (SQLException e) {
            Log.e(TAG, "CREATE SCORE ERROR", e);
            return new ArrayList<>();
        }
    }
}
