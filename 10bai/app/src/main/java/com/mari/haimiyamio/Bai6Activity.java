package com.mari.haimiyamio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

import java.util.ArrayList;

public class Bai6Activity extends AppCompatActivity {

    EditText edtName, edtPrice, edtQty;
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
        setContentView(R.layout.activity_bai6);

        edtName = findViewById(R.id.edtName);
        edtPrice = findViewById(R.id.edtPrice);
        edtQty = findViewById(R.id.edtQty);
        spinnerType = findViewById(R.id.spinnerType);
        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);
        listView = findViewById(R.id.listView);
        tvTotal = findViewById(R.id.tvTotal);

        String[] types = {"Điện tử", "Thời trang", "Gia dụng"};
        spinnerType.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, types));

        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        btnAdd.setOnClickListener(v -> addProduct());
    }

    private void addProduct(){

        String name = edtName.getText().toString();
        double price = Double.parseDouble(edtPrice.getText().toString());
        int qty = Integer.parseInt(edtQty.getText().toString());
        String type = spinnerType.getSelectedItem().toString();

        double money = price * qty;
        total += money;

        list.add(name + " (" + type + ") - " + money + " VNĐ");
        adapter.notifyDataSetChanged();

        tvTotal.setText("Tổng tiền: " + total + " VNĐ");
    }
}