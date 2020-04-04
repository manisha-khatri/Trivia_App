package com.example.triviaapp.database;

import com.example.triviaapp.model.GameInfo;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface GameInfoDao {

    @Insert
    void saveGameInfo(GameInfo gameInfo);

    @Query("select * from GameInfo")
    List<GameInfo> fetchGamesList();

}

