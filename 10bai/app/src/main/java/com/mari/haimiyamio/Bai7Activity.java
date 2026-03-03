package com.mari.haimiyamio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class Bai7Activity extends AppCompatActivity {

    EditText edtName, edtCMND, edtDays;
    RadioGroup rgRoom;
    CheckBox cbService;
    TextView tvResult;
    Button btnBook, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);

        edtName = findViewById(R.id.edtName);
        edtCMND = findViewById(R.id.edtCMND);
        edtDays = findViewById(R.id.edtDays);
        rgRoom = findViewById(R.id.rgRoom);
        cbService = findViewById(R.id.cbService);
        tvResult = findViewById(R.id.tvResult);
        btnBook = findViewById(R.id.btnBook);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        btnBook.setOnClickListener(v -> calculate());
    }

    private void calculate() {

        if(rgRoom.getCheckedRadioButtonId() == -1){
            Toast.makeText(this,"Chọn loại phòng",Toast.LENGTH_SHORT).show();
            return;
        }

        int days = Integer.parseInt(edtDays.getText().toString());

        int pricePerDay = 0;
        if(rgRoom.getCheckedRadioButtonId() == R.id.rbStandard){
            pricePerDay = 500000;
        } else {
            pricePerDay = 1000000;
        }

        int total = pricePerDay * days;

        if(cbService.isChecked()){
            total += 200000;
        }

        if(days > 5){
            total *= 0.9; // giảm 10%
        }

        tvResult.setText("Tổng tiền: " + total + " VNĐ");
    }
}