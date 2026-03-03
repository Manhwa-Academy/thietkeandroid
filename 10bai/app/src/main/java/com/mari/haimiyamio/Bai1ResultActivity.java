package com.mari.haimiyamio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class Bai1ResultActivity extends AppCompatActivity {

    TextView tvInfo;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_result);

        tvInfo = findViewById(R.id.tvInfo);
        btnBack = findViewById(R.id.btnBack);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");
        String hobby = getIntent().getStringExtra("hobby");

        String info = "Họ tên: " + name +
                "\nEmail: " + email +
                "\nGiới tính: " + gender +
                "\nSở thích: " + hobby;

        tvInfo.setText(info);

        btnBack.setOnClickListener(v -> finish());
    }
}