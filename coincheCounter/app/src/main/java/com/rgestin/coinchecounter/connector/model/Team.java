package com.rgestin.coinchecounter.connector.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by Ronan GESTIN on 27/06/2016.
 */
@DatabaseTable(tableName = "team")
@Data
public class Team implements Serializable {
    private static final String TABLE_SCORE_ID = "id";

    @DatabaseField(columnName = TABLE_SCORE_ID, generatedId = true)
    Long id;

}
