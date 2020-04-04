package com.example.triviaapp.presenter;

import android.app.Application;
import android.os.AsyncTask;

import com.example.triviaapp.contract.HistoryPageContract;
import com.example.triviaapp.contract.PageThreeContract;
import com.example.triviaapp.database.GameInfoRepository;
import com.example.triviaapp.model.GameInfo;
import java.util.List;

public class HistoryPagePresenter {
    HistoryPageContract historyPageContract;
    List<GameInfo> gameInfos;

    public HistoryPagePresenter(HistoryPageContract historyPageContract){
        this.historyPageContract = historyPageContract;
    }

    public void fetchData(Application application){
        GameInfoRepository repository = new GameInfoRepository(application);
        new fetchGameListAsyncTask(repository).execute();
    }


    private  class fetchGameListAsyncTask extends AsyncTask<Void, Void, List<GameInfo>> {
        GameInfoRepository gameInfoRepository;
        fetchGameListAsyncTask(GameInfoRepository gameInfoRepository){
            this.gameInfoRepository = gameInfoRepository;
        }
        @Override
        protected List<GameInfo> doInBackground(Void... voids) {
            return gameInfoRepository.fetchGameInfo();
        }
        protected void onPostExecute(List<GameInfo> gameInfos){
            if(gameInfos.size()>0)
                historyPageContract.displayGameInfo(gameInfos);
        }
    }




}
