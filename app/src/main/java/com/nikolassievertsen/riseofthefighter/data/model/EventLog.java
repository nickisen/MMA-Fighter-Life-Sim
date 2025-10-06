package com.nikolassievertsen.riseofthefighter.data.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "event_logs",
        foreignKeys = @ForeignKey(entity = Fighter.class,
                parentColumns = "id",
                childColumns = "fighterId",
                onDelete = ForeignKey.CASCADE))
public class EventLog {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int fighterId;
    public String message;
    public long timestamp;
}