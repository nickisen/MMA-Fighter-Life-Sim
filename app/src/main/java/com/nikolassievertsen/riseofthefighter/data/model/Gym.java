package com.nikolassievertsen.riseofthefighter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gyms")
public class Gym {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public float gymModifier; // e.g., 1.0 for basic, 0.8 for mid, 1.2 for world-class
    public double monthlyCost;
    public int coachQuality; // 1-100
    public String locationTier; // e.g., "Local", "National", "World-Class"
}