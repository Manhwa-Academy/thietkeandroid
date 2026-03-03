package com.mari.laptrinhsukien;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.btnB1).setOnClickListener(v ->
                startActivity(new Intent(this, CalculatorActivity.class)));

        findViewById(R.id.btnB2).setOnClickListener(v ->
                startActivity(new Intent(this, AverageActivity.class)));

        findViewById(R.id.btnB3).setOnClickListener(v ->
                startActivity(new Intent(this, ConvertActivity.class)));
    }
}