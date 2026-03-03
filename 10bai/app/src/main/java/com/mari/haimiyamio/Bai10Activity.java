package com.mari.haimiyamio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

import java.util.ArrayList;

public class Bai10Activity extends AppCompatActivity {

    EditText edtName, edtPrice, edtQty;
    Button btnAdd, btnPay, btnBack;
    ListView listView;
    TextView tvTotal;

    ArrayList<String> cart;
    ArrayAdapter<String> adapter;
    double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai10);

        edtName = findViewById(R.id.edtName);
        edtPrice = findViewById(R.id.edtPrice);
        edtQty = findViewById(R.id.edtQty);
        btnAdd = findViewById(R.id.btnAdd);
        btnPay = findViewById(R.id.btnPay);
        btnBack = findViewById(R.id.btnBack);
        listView = findViewById(R.id.listView);
        tvTotal = findViewById(R.id.tvTotal);

        cart = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cart);
        listView.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());
        btnAdd.setOnClickListener(v -> addProduct());
        btnPay.setOnClickListener(v -> pay());
    }

    private void addProduct(){

        String name = edtName.getText().toString();
        double price = Double.parseDouble(edtPrice.getText().toString());
        int qty = Integer.parseInt(edtQty.getText().toString());

        double money = price * qty;
        total += money;

        cart.add(name + " - SL: " + qty + " - " + money + " VNĐ");
        adapter.notifyDataSetChanged();

        tvTotal.setText("Tổng tiền: " + total + " VNĐ");
    }

    private void pay(){

        new AlertDialog.Builder(this)
                .setTitle("Xác nhận thanh toán")
                .setMessage("Thanh toán tổng tiền: " + total + " VNĐ?")
                .setPositiveButton("OK", (d,w)->{
                    cart.clear();
                    adapter.notifyDataSetChanged();
                    total = 0;
                    tvTotal.setText("Tổng tiền: 0 VNĐ");
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}