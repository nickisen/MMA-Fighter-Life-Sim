package com.nikolassievertsen.riseofthefighter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "jobs")
public class Job {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public double weeklyIncome;
    public int energyCost;
}