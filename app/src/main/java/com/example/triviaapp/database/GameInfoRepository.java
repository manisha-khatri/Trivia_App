package com.example.triviaapp.database;

import android.app.Application;
import android.os.AsyncTask;
import com.example.triviaapp.model.GameInfo;
import java.util.List;

public class GameInfoRepository {
    public GameInfoDao gameInfoDao;

    public GameInfoRepository(Application application){
        GameInfoDatabase db = GameInfoDatabase.getInstance(application);
        gameInfoDao = db.gameInfoDao();
    }

    public void saveGameInfo(GameInfo gameInfo){
        new saveGameInfoAsyncTask(gameInfoDao).execute(gameInfo); //constructor(dao)
    }

    public List<GameInfo>  fetchGameInfo(){
        List<GameInfo> gamesList = gameInfoDao.fetchGamesList();
        return gamesList;
    }

    private static class saveGameInfoAsyncTask extends AsyncTask<GameInfo, Void, Void> {
        private GameInfoDao gameInfoDao1;

        public saveGameInfoAsyncTask(GameInfoDao gameInfoDao1){
            this.gameInfoDao1 = gameInfoDao1;
        }

        @Override
        protected Void doInBackground(GameInfo... games) {
            gameInfoDao1.saveGameInfo(games[0]);
            return null;
        }
    }
}
