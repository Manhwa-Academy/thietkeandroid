package com.mari.haimiyamio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.ArrayList;

public class Bai8Activity extends AppCompatActivity {

    EditText edtName, edtMoney;
    Spinner spinnerType;
    Button btnAdd, btnBack;
    ListView listView;
    TextView tvTotal;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8);

        edtName = findViewById(R.id.edtName);
        edtMoney = findViewById(R.id.edtMoney);
        spinnerType = findViewById(R.id.spinnerType);
        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);
        listView = findViewById(R.id.listView);
        tvTotal = findViewById(R.id.tvTotal);

        String[] types = {"Ăn uống", "Di chuyển", "Mua sắm"};
        spinnerType.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, types));

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        btnAdd.setOnClickListener(v -> addExpense());
    }

    private void addExpense(){

        String name = edtName.getText().toString();
        double money = Double.parseDouble(edtMoney.getText().toString());
        String type = spinnerType.getSelectedItem().toString();

        total += money;

        list.add(name + " (" + type + ") - " + money + " VNĐ");
        adapter.notifyDataSetChanged();

        tvTotal.setText("Tổng: " + total + " VNĐ");

        if(total > 5000000){
            Toast.makeText(this,"Cảnh báo: vượt 5 triệu!",Toast.LENGTH_LONG).show();
        }
    }
}