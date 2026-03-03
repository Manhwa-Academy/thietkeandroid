package com.mari.haimiyamio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;

public class Bai4Activity extends AppCompatActivity {

    EditText edtName, edtDays;
    Spinner spinnerPosition;
    CheckBox cbOT;
    TextView tvSalary;
    Button btnCalc, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        edtName = findViewById(R.id.edtName);
        edtDays = findViewById(R.id.edtDays);
        spinnerPosition = findViewById(R.id.spinnerPosition);
        cbOT = findViewById(R.id.cbOT);
        tvSalary = findViewById(R.id.tvSalary);
        btnCalc = findViewById(R.id.btnCalc);
        btnBack = findViewById(R.id.btnBack);

        String[] positions = {"Giám đốc", "Trưởng phòng", "Nhân viên"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                positions
        );
        spinnerPosition.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        btnCalc.setOnClickListener(v -> calculateSalary());
    }

    private void calculateSalary() {

        String position = spinnerPosition.getSelectedItem().toString();
        int days = Integer.parseInt(edtDays.getText().toString());

        int base = 0;

        switch (position){
            case "Giám đốc": base = 20000000; break;
            case "Trưởng phòng": base = 15000000; break;
            case "Nhân viên": base = 10000000; break;
        }

        if(cbOT.isChecked()){
            base += 500000;
        }

        if(days < 20){
            Toast.makeText(this,"Ngày công thấp!",Toast.LENGTH_SHORT).show();
        }

        tvSalary.setText("Lương: " + base + " VNĐ");

        if(base > 20000000){
            tvSalary.setTextColor(Color.RED);
        }else{
            tvSalary.setTextColor(Color.BLACK);
        }
    }
}