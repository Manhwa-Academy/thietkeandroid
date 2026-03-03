package com.mari.haimiyamio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openActivity(R.id.btnBai1, Bai1Activity.class);
        openActivity(R.id.btnBai2, Bai2Activity.class);
        openActivity(R.id.btnBai3, Bai3Activity.class);
        openActivity(R.id.btnBai4, Bai4Activity.class);
        openActivity(R.id.btnBai5, Bai5Activity.class);
        openActivity(R.id.btnBai6, Bai6Activity.class);
        openActivity(R.id.btnBai7, Bai7Activity.class);
        openActivity(R.id.btnBai8, Bai8Activity.class);
        openActivity(R.id.btnBai9, Bai9Activity.class);
        openActivity(R.id.btnBai10, Bai10Activity.class);
    }

    private void openActivity(int buttonId, Class<?> activityClass) {
        Button btn = findViewById(buttonId);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, activityClass);
            startActivity(intent);
        });
    }
}