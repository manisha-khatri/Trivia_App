package com.example.triviaapp.contract;

import com.example.triviaapp.model.GameInfo;

import java.util.List;

public interface HistoryPageContract {

    public void displayGameInfo(List<GameInfo> gameList);
}
