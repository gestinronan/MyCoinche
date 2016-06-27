package com.rgestin.coinchecounter.service.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.rgestin.coinchecounter.connector.DbHelper;
import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.connector.model.Team;
import com.rgestin.coinchecounter.service.PartieService;

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
public class PartieSerivceImpl implements PartieService {

    private static final String TAG = "TAG";

    @RootContext
    protected Context context;

    @OrmLiteDao(helper = DbHelper.class)
    Dao<Team, Long> teamDao;

    @OrmLiteDao(helper = DbHelper.class)
    Dao<Partie, Long> partieDao;


    @Override
    public List<Team> getTeam(@NonNull final Partie partie) {
        try {
            return teamDao.queryBuilder().where().eq(Team.TABLE_TEAM_PARTIE, partie).query();
        } catch (SQLException e) {
            Log.e(TAG, "GET TEAM ERROR", e);
            return new ArrayList<>();
        }
    }

    @Override
    public Partie createpratie(@NonNull String name) {
        Partie partie = new Partie();
        partie.setTitle(name);
        try {
            partieDao.create(partie);
            return partie;
        } catch (SQLException e) {
            Log.e(TAG, "CREATE PARTIE ERROR", e);
            return null;
        }
    }

    @Override
    public List<Partie> getAllPartie() {
        try {
            return partieDao.queryForAll();
        } catch (SQLException e) {
            Log.e(TAG, "GET ALL PARTIE ERROR", e);
            return new ArrayList<>();
        }
    }
}
