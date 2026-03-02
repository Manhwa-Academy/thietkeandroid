package com.mari.haimiyamio;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import android.widget.ImageView;
import android.view.View;

public class Bai2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        // Đặt tiêu đề (không cần mũi tên ActionBar nữa)
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bài 2 - Đăng nhập");
        }

        // Load GIF
        ImageView logo = findViewById(R.id.logo);
        Glide.with(this)
                .asGif()
                .load(R.drawable.low)
                .into(logo);

        // Nút Quay lại trong layout
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}