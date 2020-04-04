package com.example.triviaapp.view;

import android.os.Bundle;
import com.example.triviaapp.R;
import com.example.triviaapp.contract.HistoryPageContract;
import com.example.triviaapp.model.GameInfo;
import com.example.triviaapp.presenter.HistoryPagePresenter;
import com.example.triviaapp.view.adapter.GameInfoRecyclerViewAdapter;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PageHistoryActivity extends AppCompatActivity implements HistoryPageContract {

    RecyclerView recyclerView;
    HistoryPagePresenter historyPagePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_history);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview);
        historyPagePresenter = new HistoryPagePresenter(this);
        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {
        historyPagePresenter.fetchData(getApplication());
    }

    public void displayGameInfo(List<GameInfo> gameInfos){
        setGameInfoAdapter(gameInfos);
    }

    public void setGameInfoAdapter(List<GameInfo> gameInfoList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        GameInfoRecyclerViewAdapter customAdapter = new GameInfoRecyclerViewAdapter(gameInfoList,this);
        recyclerView.setAdapter(customAdapter);
    }
}

