package com.example.triviaapp.database;

import android.content.Context;
import com.example.triviaapp.model.GameInfo;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {GameInfo.class}, version = 1, exportSchema = false)
public abstract class GameInfoDatabase extends RoomDatabase {

    public static GameInfoDatabase dbInstance;
    public abstract GameInfoDao gameInfoDao();

    public static synchronized GameInfoDatabase getInstance(Context context){
        if(dbInstance == null)
        {
            synchronized(GameInfoDatabase.class) {
                dbInstance = Room.databaseBuilder(context.getApplicationContext(), GameInfoDatabase.class, "game_database")
                        .build();
            }
        }
        return dbInstance;
    }

}
