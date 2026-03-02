package com.mari.haimiyamio;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.b1).setOnClickListener(v ->
                startActivity(new Intent(this, Bai1Activity.class)));

        findViewById(R.id.b2).setOnClickListener(v ->
                startActivity(new Intent(this, Bai2Activity.class)));

        findViewById(R.id.b3).setOnClickListener(v ->
                startActivity(new Intent(this, Bai3Activity.class)));

        findViewById(R.id.b4).setOnClickListener(v ->
                startActivity(new Intent(this, Bai4Activity.class)));

        findViewById(R.id.b5).setOnClickListener(v ->
                startActivity(new Intent(this, Bai5Activity.class)));
    }
}