package com.mari.haimiyamio;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class Bai4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        // Đặt tiêu đề
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bài 4 - Profile");
        }

        // Fragment mặc định
        loadFragment(new ThongTinFragment());

        // Nút chuyển Fragment
        findViewById(R.id.btnThongTin).setOnClickListener(v ->
                loadFragment(new ThongTinFragment()));

        findViewById(R.id.btnLichSu).setOnClickListener(v ->
                loadFragment(new LichSuFragment()));

        findViewById(R.id.btnCaiDat).setOnClickListener(v ->
                loadFragment(new CaiDatFragment()));

        // Nút quay lại
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        // Load GIF avatar
        ImageView avatar = findViewById(R.id.imgAvatar);
        Glide.with(this)
                .asGif()
                .load(R.drawable.low)
                .circleCrop()
                .into(avatar);
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}