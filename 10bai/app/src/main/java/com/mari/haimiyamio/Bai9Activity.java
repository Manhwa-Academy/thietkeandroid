package com.mari.haimiyamio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class Bai9Activity extends AppCompatActivity {

    EditText edtName, edtMSSV;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    TextView tvResult;
    Button btnCalc, btnReset, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai9);

        edtName = findViewById(R.id.edtName);
        edtMSSV = findViewById(R.id.edtMSSV);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);
        tvResult = findViewById(R.id.tvResult);
        btnCalc = findViewById(R.id.btnCalc);
        btnReset = findViewById(R.id.btnReset);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());
        btnCalc.setOnClickListener(v -> calculate());
        btnReset.setOnClickListener(v -> resetForm());
    }

    private void calculate(){

        int count = 0;

        if(cb1.isChecked()) count++;
        if(cb2.isChecked()) count++;
        if(cb3.isChecked()) count++;
        if(cb4.isChecked()) count++;
        if(cb5.isChecked()) count++;

        double total = count * 500000;

        if(count >= 4){
            total *= 0.95; // giảm 5%
        }

        tvResult.setText("Tổng học phí: " + total + " VNĐ");
    }

    private void resetForm(){
        edtName.setText("");
        edtMSSV.setText("");
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        cb5.setChecked(false);
        tvResult.setText("");
    }
}