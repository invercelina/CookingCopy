package com.example.cooking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    public int hour = 0;
    public int minute = 0;
    public int second = 0;

    public TextView tvhour;
    public TextView tvminute;
    public TextView tvsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText ethour = findViewById(R.id.et_hour);
        EditText etminute = findViewById(R.id.et_minute);
        EditText etsecond = findViewById(R.id.et_second);

        tvhour = findViewById(R.id.tv_hour);
        tvminute = findViewById(R.id.tv_minute);
        tvsecond = findViewById(R.id.tv_second);

        Button startbtn = findViewById(R.id.btn_start);



        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ethour.setVisibility(View.INVISIBLE);
                etminute.setVisibility(View.INVISIBLE);
                etsecond.setVisibility(View.INVISIBLE);

                tvhour.setVisibility(View.VISIBLE);
                tvminute.setVisibility(View.VISIBLE);
                tvsecond.setVisibility(View.VISIBLE);

                hour = Integer.parseInt(ethour.getText().toString());
                minute = Integer.parseInt(etminute.getText().toString());
                second = Integer.parseInt(etsecond.getText().toString());

                startTimer();

            }
        });

    }


    public void startTimer() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                tvhour.setText(String.format("%02d",hour));
                tvminute.setText(String.format("%02d",minute));
                tvsecond.setText(String.format("%02d",second));

                if(second!=0){
                    second--;
                } else if(minute!=0){
                    second=59;
                    minute--;
                } else if(hour!=0){
                    second=59;
                    minute=59;
                    hour--;
                }
                if(hour==0&&minute==0&&second==0){
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,1000);
    }

}