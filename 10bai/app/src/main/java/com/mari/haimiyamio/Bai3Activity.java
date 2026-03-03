package com.mari.haimiyamio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

public class Bai3Activity extends AppCompatActivity {

    EditText edtName;
    Spinner spinnerMovie;
    RadioGroup rgTime;
    CheckBox cbCombo;
    Button btnBook, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        edtName = findViewById(R.id.edtName);
        spinnerMovie = findViewById(R.id.spinnerMovie);
        rgTime = findViewById(R.id.rgTime);
        cbCombo = findViewById(R.id.cbCombo);
        btnBook = findViewById(R.id.btnBook);
        btnBack = findViewById(R.id.btnBack);

        String[] movies = {"Avengers", "One Piece", "Doraemon"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                movies
        );
        spinnerMovie.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        btnBook.setOnClickListener(v -> bookTicket());
    }

    private void bookTicket() {

        String name = edtName.getText().toString();

        if(name.isEmpty()){
            Toast.makeText(this,"Nhập tên khách hàng",Toast.LENGTH_SHORT).show();
            return;
        }

        if(rgTime.getCheckedRadioButtonId() == -1){
            Toast.makeText(this,"Chọn suất chiếu",Toast.LENGTH_SHORT).show();
            return;
        }

        int total = 70000;
        if(cbCombo.isChecked()){
            total += 30000;
        }

        new AlertDialog.Builder(this)
                .setTitle("Xác nhận đặt vé")
                .setMessage("Tổng tiền: " + total + " VNĐ")
                .setPositiveButton("OK", null)
                .setNegativeButton("Hủy", null)
                .show();
    }
}