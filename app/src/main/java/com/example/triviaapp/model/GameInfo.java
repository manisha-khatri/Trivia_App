package com.example.triviaapp.model;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GameInfo {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo
    int id;

    @ColumnInfo
    String startTime;

    @ColumnInfo
    String userName;

    @ColumnInfo
    String bestCricketerName;

    @ColumnInfo
    String indianFlagColors;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBestCricketerName() {
        return bestCricketerName;
    }

    public void setBestCricketerName(String bestCricketerName) {
        this.bestCricketerName = bestCricketerName;
    }

    public String getIndianFlagColors() {
        return indianFlagColors;
    }

    public void setIndianFlagColors(String indianFlagColors) {
        this.indianFlagColors = indianFlagColors;
    }

}
