package com.nikolassievertsen.riseofthefighter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fighters")
public class Fighter {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int age;
    public String weightClass;
    public double money;

    // Base Stats
    public int strength;
    public int speed;
    public int endurance;
    public int durability;

    // Technical Stats
    public int striking;
    public int grappling;
    public int wrestling;
    public int clinch;

    // Mental Stats
    public int fightIQ;
    public int confidence;
    public int discipline;

    // Game State
    public int fatigue;
    public int health;
    public int energyCapBase = 100;
    public int energyBonus;
    public int fanPopularity;
    public String contractTier;
    public int currentGymId;
}