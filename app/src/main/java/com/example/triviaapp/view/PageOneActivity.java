package com.example.triviaapp.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.triviaapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PageOneActivity extends AppCompatActivity {

    EditText userNameET;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_one);
        initViews();
        onNextButtonClickListener();
    }

    private void initViews() {
        userNameET = findViewById(R.id.user_name);
        nextBtn = findViewById(R.id.page_one_next_btn);
    }

    void onNextButtonClickListener() {
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(PageOneActivity.this, PageTwoActivity.class);
                String userName,startTime;
                userName = (userNameET.getText().toString() != null)? userNameET.getText().toString():" ";
                startTime = (timeCalculator() != null)? timeCalculator():" ";
                intent.putExtra("USER_NAME", userName);
                intent.putExtra("GAME_START_TIME", startTime);
                startActivity(intent);
            }
        });
    }

    String timeCalculator(){
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.ss aa");
        String output = dateFormat.format(currentTime);
        return output;
    }
}
