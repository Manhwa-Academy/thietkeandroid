package com.mari.haimiyamio;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class ThemSinhVienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Thêm sinh viên");
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}