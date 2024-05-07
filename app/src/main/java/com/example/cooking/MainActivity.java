package com.example.cooking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public EditText ethour;
    public EditText etminute;
    public EditText etsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ethour = findViewById(R.id.et_hour);
        etminute = findViewById(R.id.et_minute);
        etsecond = findViewById(R.id.et_second);

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

                hour = ethour.length()==0 ? 0 : Integer.parseInt(ethour.getText().toString());
                minute = etminute.length()==0 ? 0 : Integer.parseInt(etminute.getText().toString());
                second = etsecond.length()==0 ? 0 : Integer.parseInt(etsecond.getText().toString());

                startTimer();

            }
        });

    }


    public void startTimer() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        tvhour.setText(String.format("%02d", hour));
                        tvminute.setText(String.format("%02d", minute));
                        tvsecond.setText(String.format("%02d", second));

                        if (second != 0) {
                            second--;
                        } else if (minute != 0) {
                            second = 59;
                            minute--;
                        } else if (hour != 0) {
                            second = 59;
                            minute = 59;
                            hour--;
                        } else {
                            Toast.makeText(MainActivity.this, "타이머가 종료되었습니다", Toast.LENGTH_SHORT).show();
                            ethour.setVisibility(View.VISIBLE);
                            etminute.setVisibility(View.VISIBLE);
                            etsecond.setVisibility(View.VISIBLE);

                            tvhour.setVisibility(View.INVISIBLE);
                            tvminute.setVisibility(View.INVISIBLE);
                            tvsecond.setVisibility(View.INVISIBLE);

                            ethour.setText("");
                            etminute.setText("");
                            etsecond.setText("");

                            ethour.setHint("00");
                            etminute.setHint("00");
                            etsecond.setHint("00");

                            timer.cancel();

                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,0,1000);
    }

}