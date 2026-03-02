package com.mari.haimiyamio;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import android.widget.ImageView;

public class Bai1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        // Đặt tiêu đề
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bài 1 - Thông tin cá nhân");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // hiện mũi tên back
        }

        // Load GIF
        ImageView img = findViewById(R.id.imgAvatar);
        Glide.with(this)
                .asGif()
                .load(R.drawable.low)
                .into(img);

        // Nếu có nút Back trong layout
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }

    // Xử lý khi bấm mũi tên trên ActionBar
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}