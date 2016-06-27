package com.rgestin.coinchecounter.connector.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by Ronan GESTIN on 27/06/2016.
 */
@DatabaseTable(tableName = "partie")
@Data
public class Partie implements Serializable {

    private static final String TABLE_PARTIE_ID = "id";
    private static final String TABLE_PARTIE_TITLE = "title";
    private static final String TABLE_PARTIE_SCORE_LIST = "ScoreListe";


    @DatabaseField(columnName = TABLE_PARTIE_ID, generatedId = true)
    Long id;

    @DatabaseField(columnName = TABLE_PARTIE_TITLE, generatedId = true)
    String title;

    @ForeignCollectionField(columnName = TABLE_PARTIE_SCORE_LIST)
    ForeignCollection<Score> Scores;

}
