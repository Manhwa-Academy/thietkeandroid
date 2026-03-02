package com.mari.haimiyamio;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Bai5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);

        // Tiêu đề
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bài 5 - Quản lý lớp học");
        }

        // Nút quay lại
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        // Sinh viên → mở Danh sách sinh viên
        findViewById(R.id.btnSinhVien).setOnClickListener(v ->
                startActivity(new Intent(this, DanhSachSinhVienActivity.class)));

        findViewById(R.id.btnGiangVien).setOnClickListener(v ->
                startActivity(new Intent(this, DanhSachSinhVienActivity.class)));

        findViewById(R.id.btnMonHoc).setOnClickListener(v ->
                startActivity(new Intent(this, DanhSachSinhVienActivity.class)));

        findViewById(R.id.btnThongKe).setOnClickListener(v ->
                startActivity(new Intent(this, DanhSachSinhVienActivity.class)));
    }
}