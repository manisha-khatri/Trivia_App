package com.example.triviaapp.presenter;

import android.app.Application;

import com.example.triviaapp.contract.PageThreeContract;
import com.example.triviaapp.database.GameInfoRepository;
import com.example.triviaapp.model.GameInfo;

public class PageThreePresenter {
    PageThreeContract pageThreeContract;

    public PageThreePresenter(){
    }

    public void saveData(GameInfo gameInfo, Application application){
        GameInfoRepository repository = new GameInfoRepository(application);
        repository.saveGameInfo(gameInfo);
    }

}
