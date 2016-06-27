package com.rgestin.coinchecounter.connector;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.rgestin.coinchecounter.connector.model.Partie;
import com.rgestin.coinchecounter.connector.model.Score;

import java.sql.SQLException;

/**
 * Created by Ronan GESTIN on 27/06/2016.
 */
public class DbHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "coinchCounter";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = DbHelper.class.getSimpleName();


    /**
     * The data access object used to interact with the Sqlite database to do C.R.U.D operations.
     */
    private Dao<Partie, Long> mPartieLongDao;
    private Dao<Score, Long> mScoreLongDao;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase database, final ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Partie.class);
            TableUtils.createTable(connectionSource, Score.class);

        } catch (SQLException e) {
            Log.e(TAG, "DATABASE CREATION ERROR");
        }
    }

    @Override
    public void onUpgrade(final SQLiteDatabase database, final ConnectionSource connectionSource, final int oldVersion, final int newVersion) {

        DropTable(connectionSource);
        onCreate(database, connectionSource);

    }

    private void DropTable(final ConnectionSource connectionSource) {
        try {
            TableUtils.dropTable(connectionSource, Partie.class, false);

            TableUtils.dropTable(connectionSource, Score.class, false);
        } catch (SQLException e) {
            Log.e(TAG, "DATABASE DROP ERROR");
        }
    }

    /**
     * Returns an instance of the data access object PARTIE
     * @return dao
     * @throws SQLException
     */
    public Dao<Partie, Long> getPartieDao() throws SQLException {
        if(mPartieLongDao == null) {
            mPartieLongDao = getDao(Partie.class);
        }
        return mPartieLongDao;
    }

    /**
     * Returns an instance of the data access object SCORE
     * @return doa score
     * @throws SQLException
     */
    public Dao<Score, Long> getScoreDao() throws SQLException {
        if(mScoreLongDao == null) {
            mScoreLongDao = getDao(Score.class);
        }
        return mScoreLongDao;
    }
}
