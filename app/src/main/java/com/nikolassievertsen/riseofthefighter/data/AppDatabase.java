package com.nikolassievertsen.riseofthefighter.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nikolassievertsen.riseofthefighter.data.dao.*;
import com.nikolassievertsen.riseofthefighter.data.model.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Fighter.class, Gym.class, TrainingSession.class, Fight.class, Job.class, EventLog.class, GameState.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FighterDao fighterDao();
    public abstract GymDao gymDao();
    // ... other DAOs

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "rise_of_the_fighter_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}