package com.rgestin.coinchecounter.business.service.impl;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.rgestin.coinchecounter.connector.DbHelper;
import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.connector.model.Team;
import com.rgestin.coinchecounter.business.service.TeamService;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;

/**
 * Created by ronan GESTIN on 27/06/2016.
 */
@EBean
public class TeamServiceImpl implements TeamService {

    private static final String TAG = TeamServiceImpl.class.getSimpleName();

    @RootContext
    protected Context context;

    @OrmLiteDao(helper = DbHelper.class)
    Dao<Team, Long> teamLongDao;

    @Override
    public Team createTeam(Partie partie, String name) {
        Team team = new Team();
        team.setName(name);
        team.setPartie(partie);

        try {
            teamLongDao.create(team);
        } catch (SQLException e) {
            Log.e(TAG, "CREATE TEAM ERROR", e);
            return null;
        }
        return team;
    }
}
