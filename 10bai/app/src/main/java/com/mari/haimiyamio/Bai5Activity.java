package com.mari.haimiyamio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

public class Bai5Activity extends AppCompatActivity {

    RadioGroup rg1, rg2, rg3, rg4, rg5;
    Button btnSubmit, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        rg4 = findViewById(R.id.rg4);
        rg5 = findViewById(R.id.rg5);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());
        btnSubmit.setOnClickListener(v -> submit());
    }

    private void submit(){

        if(rg1.getCheckedRadioButtonId()==-1 ||
                rg2.getCheckedRadioButtonId()==-1 ||
                rg3.getCheckedRadioButtonId()==-1 ||
                rg4.getCheckedRadioButtonId()==-1 ||
                rg5.getCheckedRadioButtonId()==-1){

            Toast.makeText(this,"Chọn đủ 5 câu!",Toast.LENGTH_SHORT).show();
            return;
        }

        int score = 0;

        if(rg1.getCheckedRadioButtonId()==R.id.q1b) score+=2;
        if(rg2.getCheckedRadioButtonId()==R.id.q2b) score+=2;
        if(rg3.getCheckedRadioButtonId()==R.id.q3c) score+=2;
        if(rg4.getCheckedRadioButtonId()==R.id.q4a) score+=2;
        if(rg5.getCheckedRadioButtonId()==R.id.q5a) score+=2;

        String rank;
        if(score <=4) rank="Yếu";
        else if(score<=7) rank="Trung bình";
        else rank="Tốt";

        new AlertDialog.Builder(this)
                .setTitle("Kết quả")
                .setMessage("Điểm: "+score+"\nXếp loại: "+rank)
                .setPositiveButton("OK",null)
                .show();
    }
}