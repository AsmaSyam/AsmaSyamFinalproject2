package com.example.asmasyamfinalproject.Class;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.asmasyamfinalproject.Dao.LevelDao;
import com.example.asmasyamfinalproject.Dao.PatternDao;
import com.example.asmasyamfinalproject.Dao.QuestionDao;
import com.example.asmasyamfinalproject.Dao.UsersDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DataOfLevel.class , QuestionData.class , DataOfUsers.class , Pattern.class}, version = 1, exportSchema = false)
public abstract class GameDatabase extends RoomDatabase {

    public abstract LevelDao levelDao();
    public abstract QuestionDao questionDao();
    public abstract UsersDao usersDao();
    public abstract PatternDao patternDao();

    private static volatile GameDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static GameDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (GameDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GameDatabase.class, "game_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
