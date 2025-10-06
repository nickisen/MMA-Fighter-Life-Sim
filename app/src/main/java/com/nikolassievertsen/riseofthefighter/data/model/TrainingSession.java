package com.nikolassievertsen.riseofthefighter.data.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "training_sessions",
        foreignKeys = {
                @ForeignKey(entity = Fighter.class,
                        parentColumns = "id",
                        childColumns = "fighterId",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Gym.class,
                        parentColumns = "id",
                        childColumns = "gymId",
                        onDelete = ForeignKey.SET_NULL)
        })
public class TrainingSession {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int fighterId;
    public String skillTarget; // e.g., "striking", "grappling"
    public int expGained;
    public int energySpent;
    public double moneySpent;
    public long timestamp;
    public Integer gymId;
    public String sessionType; // e.g., "Light", "Intense", "Sparring"
}