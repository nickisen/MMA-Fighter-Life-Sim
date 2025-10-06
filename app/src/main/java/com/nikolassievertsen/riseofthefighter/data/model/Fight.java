package com.nikolassievertsen.riseofthefighter.data.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "fights",
        foreignKeys = @ForeignKey(entity = Fighter.class,
                parentColumns = "id",
                childColumns = "fighterId",
                onDelete = ForeignKey.CASCADE))
public class Fight {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int fighterId;
    public int opponentId; // Can be nullable if we don't store opponents in the DB
    public String opponentName;
    public String promotionTier; // e.g., "Local", "Regional", "World"
    public String result; // "WIN", "LOSS", "DRAW"
    public String method; // "KO", "SUB", "DEC"
    public double moneyEarned;
    public int reputationChange;
    public String injurySeverity; // e.g., "None", "Minor", "Major"
    public int rating; // 1-5 stars
}