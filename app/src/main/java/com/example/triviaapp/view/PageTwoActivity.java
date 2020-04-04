package com.example.triviaapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.triviaapp.R;
import androidx.appcompat.app.AppCompatActivity;

public class PageTwoActivity extends AppCompatActivity {
    Button nextBtn;
    private RadioGroup radioCricketersGroup;
    private RadioButton radioCricketerButton;
    String userName, gameStartTime;
    String selectedCricketerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);
        initViews();
        onNextButtonClickListener();
    }

    private void initViews() {
        nextBtn = findViewById(R.id.page_two_next_btn);
        radioCricketersGroup = findViewById(R.id.cricketer_radio_group);
        userName = getIntent().getStringExtra("USER_NAME");
        gameStartTime = getIntent().getStringExtra("GAME_START_TIME");

    }

    void onNextButtonClickListener() {
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                saveSelectedCricketerOptions();
                Intent intent = new Intent(PageTwoActivity.this, PageThreeActivity.class);
                intent.putExtra("USER_NAME", userName);
                intent.putExtra("GAME_START_TIME", gameStartTime);
                intent.putExtra("GAME_BEST_CRICKETER", selectedCricketerName);
                startActivity(intent);
            }
        });
    }

    void saveSelectedCricketerOptions(){
        int selectedId = radioCricketersGroup.getCheckedRadioButtonId();
        radioCricketerButton = findViewById(selectedId);

        if(radioCricketerButton != null)
        selectedCricketerName = (radioCricketerButton.getText() != null)? radioCricketerButton.getText().toString(): " ";
        else
            selectedCricketerName = " ";
    }
}
