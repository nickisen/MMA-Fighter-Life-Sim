package com.nikolassievertsen.riseofthefighter.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.nikolassievertsen.riseofthefighter.data.model.Fighter;

@Dao
public interface FighterDao {
    @Insert
    void insert(Fighter fighter);

    @Update
    void update(Fighter fighter);

    @Query("SELECT * FROM fighters WHERE id = :id")
    LiveData<Fighter> getFighterById(int id);
}