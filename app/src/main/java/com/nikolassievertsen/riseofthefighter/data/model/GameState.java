package com.nikolassievertsen.riseofthefighter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "game_state")
public class GameState {
    @PrimaryKey
    public int id = 1; // Singleton
    public int currentWeek;
    public int currentYear;
    public int reservedEnergy;
    // For simplicity, upcoming fight info can be stored directly
    // or you could have a separate relation.
    public Integer scheduledFightId;
}