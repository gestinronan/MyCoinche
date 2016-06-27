package com.rgestin.coinchecounter.connector.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by Ronan GESTIN on 24/06/2016.
 */
@DatabaseTable(tableName = "score")
@Data
public class Score implements Serializable {

    private static final String TABLE_SCORE_ID = "id";
    private static final String TABLE_SCORE_SCORE_MANCHE = "ScoreManche";
    private static final String TABLE_SCORE_SCORE_PARTIE = "ScorePartie";
    private static final String TABLE_SCORE_TEAM = "Team";

    @DatabaseField(columnName = TABLE_SCORE_ID, generatedId = true)
    Long id;
    @DatabaseField(columnName = TABLE_SCORE_SCORE_MANCHE)
    int scoreManche;
    @DatabaseField(columnName = TABLE_SCORE_SCORE_PARTIE)
    int scorePartie;

    @DatabaseField(columnName = TABLE_SCORE_TEAM, foreign = true, foreignAutoRefresh = true)
    Team partie;
}
