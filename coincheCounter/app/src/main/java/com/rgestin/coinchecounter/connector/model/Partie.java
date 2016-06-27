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
@DatabaseTable(tableName = "partie")
@Data
public class Partie implements Serializable {

    public static final String TABLE_PARTIE_ID = "id";
    public static final String TABLE_PARTIE_TITLE = "title";
    public static final String TABLE_PARTIE_TEAM_LIST = "ScoreListe";


    @DatabaseField(columnName = TABLE_PARTIE_ID, generatedId = true)
    Long id;

    @DatabaseField(dataType = DataType.STRING, columnName = TABLE_PARTIE_TITLE)
    String title;

    @ForeignCollectionField(columnName = TABLE_PARTIE_TEAM_LIST)
    ForeignCollection<Team> teams;

}
