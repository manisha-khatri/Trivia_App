package com.example.triviaapp.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.example.triviaapp.R;
import com.example.triviaapp.model.GameInfo;
import com.example.triviaapp.model.GameParcelable;
import com.example.triviaapp.presenter.PageThreePresenter;
import java.util.ArrayList;
import java.util.List;

public class PageThreeActivity extends AppCompatActivity {
    Button nextBtn;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    String userName, gameStartTime, gameBestCricketer, gameFlagColor;
    PageThreePresenter pageThreePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);
        initViews();
        onNextButtonClickListener();
    }

    private void initViews() {
        nextBtn = findViewById(R.id.page_three_next_btn);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        pageThreePresenter = new PageThreePresenter();
        fetchDataFromIntent();
    }

    private void fetchDataFromIntent() {
        userName = getIntent().getStringExtra("USER_NAME");
        gameStartTime = getIntent().getStringExtra("GAME_START_TIME");
        gameBestCricketer = getIntent().getStringExtra("GAME_BEST_CRICKETER");
    }

    void onNextButtonClickListener() {
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                saveSelectedFlagColors();
                GameParcelable gameParcelable = new GameParcelable(gameStartTime,userName,gameBestCricketer,gameFlagColor);
                Intent intent = new Intent(PageThreeActivity.this, PageFourActivity.class);
                intent.putExtra("GAME", gameParcelable);
                startActivity(intent);
            }
        });
    }

    void saveSelectedFlagColors(){
        List<String>  selectedFlagColors = fetchSelectedFlagColor();
        String colorList = " ";

        for(int i = 0; i < selectedFlagColors.size() ; i++ )
            colorList = selectedFlagColors.get(i) + "," + colorList ;
        gameFlagColor = colorList;

        GameInfo gameInfo = new GameInfo();
        gameInfo.setUserName(userName);
        gameInfo.setStartTime(gameStartTime);
        gameInfo.setBestCricketerName(gameBestCricketer);
        gameInfo.setIndianFlagColors(gameFlagColor);

        pageThreePresenter.saveData(gameInfo,getApplication());
    }

    private List<String> fetchSelectedFlagColor() {
        List<String> colorList = new ArrayList<>();

        if(checkBox1.isChecked())
            colorList.add("White");
        if(checkBox2.isChecked())
            colorList.add("Yellow");
        if(checkBox3.isChecked())
            colorList.add("Orange");
        if(checkBox4.isChecked())
            colorList.add("Green");

        return colorList;
    }
}
