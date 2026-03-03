package com.mari.haimiyamio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Bai2Activity extends AppCompatActivity {

    EditText edtName, edtYear, edtClass;
    Button btnAdd, btnBack;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        edtName = findViewById(R.id.edtName);
        edtYear = findViewById(R.id.edtYear);
        edtClass = findViewById(R.id.edtClass);
        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);

        list = new ArrayList<>();

        btnBack.setOnClickListener(v -> finish());

        btnAdd.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            int year = Integer.parseInt(edtYear.getText().toString());
            String lop = edtClass.getText().toString();

            int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            if(year > currentYear){
                Toast.makeText(this,"Năm sinh không hợp lệ",Toast.LENGTH_SHORT).show();
                return;
            }

            list.add(name + " - " + year + " - " + lop);
            Toast.makeText(this,"Đã thêm",Toast.LENGTH_SHORT).show();
        });
    }
}