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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText ethour = findViewById(R.id.et_hour);
        EditText etminute = findViewById(R.id.et_minute);
        EditText etsecond = findViewById(R.id.et_second);

        TextView tvhour = findViewById(R.id.tv_hour);
        TextView tvminute = findViewById(R.id.tv_minute);
        TextView tvsecond = findViewById(R.id.tv_second);

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
            }
        });
    }
}