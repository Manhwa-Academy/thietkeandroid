package com.mari.haimiyamio;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class DanhSachSinhVienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_sinh_vien);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Danh sách sinh viên");
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        findViewById(R.id.btnThem).setOnClickListener(v ->
                startActivity(new Intent(this, ThemSinhVienActivity.class)));
    }
}