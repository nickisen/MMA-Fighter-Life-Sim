package com.nikolassievertsen.riseofthefighter.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.nikolassievertsen.riseofthefighter.data.model.Gym;

import java.util.List;

@Dao
public interface GymDao {
    @Insert
    void insert(Gym gym);

    @Query("SELECT * FROM gyms")
    LiveData<List<Gym>> getAllGyms();

    @Query("SELECT * FROM gyms WHERE id = :id")
    LiveData<Gym> getGymById(int id);
}