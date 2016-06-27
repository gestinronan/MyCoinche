package com.rgestin.coinchecounter.connector.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by Ronan GESTIN on 27/06/2016.
 */
@DatabaseTable(tableName = "team")
@Data
public class Team implements Serializable {

    public static final String TABLE_TEAM_ID = "id";
    public static final String TABLE_TEAM_SCORE_LIST = "listScore";
    public static final String TABLE_TEAM_NAME = "TeamName";
    public static final String TABLE_TEAM_PARTIE = "partie";

    @DatabaseField(columnName = TABLE_TEAM_ID, generatedId = true)
    Long id;

    @DatabaseField(dataType = DataType.STRING ,columnName = TABLE_TEAM_NAME)
    String name;

    @ForeignCollectionField(columnName = TABLE_TEAM_SCORE_LIST)
    ForeignCollection<Score> scores;

    @DatabaseField( dataType = DataType.SERIALIZABLE ,columnName = TABLE_TEAM_PARTIE, foreign = true, foreignAutoRefresh = true)
    Partie partie;

}
