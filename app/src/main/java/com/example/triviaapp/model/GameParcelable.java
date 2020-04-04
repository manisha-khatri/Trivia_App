package com.example.triviaapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import androidx.room.ColumnInfo;

public class GameParcelable implements Parcelable {
    public String startTime;

    public GameParcelable(String startTime, String userName, String bestCricketerName, String indianFlagColors) {
        this.startTime = startTime;
        this.userName = userName;
        this.bestCricketerName = bestCricketerName;
        this.indianFlagColors = indianFlagColors;
    }

    public String userName;
    public String bestCricketerName;
    public String indianFlagColors;

    private GameParcelable(Parcel in) {
        startTime = in.readString();
        userName = in.readString();
        bestCricketerName = in.readString();
        indianFlagColors = in.readString();
    }

    public static final Creator<GameParcelable> CREATOR = new Creator<GameParcelable>() {
        @Override
        public GameParcelable createFromParcel(Parcel in) {
            return new GameParcelable(in);
        }

        @Override
        public GameParcelable[] newArray(int size) {
            return new GameParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(startTime);
        parcel.writeString(userName);
        parcel.writeString(bestCricketerName);
        parcel.writeString(indianFlagColors);
    }
}
