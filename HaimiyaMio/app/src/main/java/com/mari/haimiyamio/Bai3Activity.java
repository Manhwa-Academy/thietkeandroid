package com.mari.haimiyamio;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Bai3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        // Đặt tiêu đề cho đẹp
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bài 3 - Danh sách môn học");
        }

        // Nút Quay lại
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // quay về MainActivity
            }
        });
    }
}