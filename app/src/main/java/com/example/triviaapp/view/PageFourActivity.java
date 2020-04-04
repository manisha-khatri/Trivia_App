package com.example.triviaapp.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.triviaapp.R;
import com.example.triviaapp.model.GameParcelable;

public class PageFourActivity extends AppCompatActivity {
    Button finishBtn;
    Button historyBtn;
    TextView userNameTV, cricketerNameTV, flagColorsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_four);
        initViews();
        onFinishButtonClickListener();
        onHistoryButtonClickListener();
    }

    private void initViews() {
        finishBtn = findViewById(R.id.finish_btn);
        historyBtn = findViewById(R.id.history_btn);
        userNameTV = findViewById(R.id.user_name_tv);
        cricketerNameTV = findViewById(R.id.cricketer_name_tv);
        flagColorsTV = findViewById(R.id.flag_colors_tv);

        fetchDataFromIntent();
    }

    private void fetchDataFromIntent() {
        GameParcelable gameParcelable = (GameParcelable) getIntent().getParcelableExtra("GAME");
        if (gameParcelable != null) {
            setData(gameParcelable);
        }
    }

    private void setData(GameParcelable gameParcelable) {
        userNameTV.setText(gameParcelable.userName);
        cricketerNameTV.setText(gameParcelable.bestCricketerName);
        flagColorsTV.setText(gameParcelable.indianFlagColors);
    }

    void onFinishButtonClickListener() {
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(PageFourActivity.this, PageOneActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    void onHistoryButtonClickListener() {
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(PageFourActivity.this, PageHistoryActivity.class);
                startActivity(intent);
            }
        });
    }

}
