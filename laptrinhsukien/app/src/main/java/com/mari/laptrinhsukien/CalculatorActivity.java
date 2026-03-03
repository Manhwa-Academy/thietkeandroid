package com.mari.laptrinhsukien;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    EditText edt1, edt2;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        txt = findViewById(R.id.txtResult);

        findViewById(R.id.btnAdd).setOnClickListener(v -> tinh("+"));
        findViewById(R.id.btnSub).setOnClickListener(v -> tinh("-"));
        findViewById(R.id.btnMul).setOnClickListener(v -> tinh("*"));
        findViewById(R.id.btnDiv).setOnClickListener(v -> tinh("/"));

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            edt1.setText("");
            edt2.setText("");
            txt.setText("Kết quả:");
        });

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }

    private void tinh(String op){

        if(edt1.getText().toString().isEmpty() ||
                edt2.getText().toString().isEmpty()){
            Toast.makeText(this,"Vui lòng nhập đủ dữ liệu",Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(edt1.getText().toString());
        double b = Double.parseDouble(edt2.getText().toString());

        if(op.equals("/") && b==0){
            txt.setText("Không thể chia cho 0");
            return;
        }

        double kq = 0;

        switch(op){
            case "+": kq = a + b; break;
            case "-": kq = a - b; break;
            case "*": kq = a * b; break;
            case "/": kq = a / b; break;
        }

        txt.setText("Kết quả: " + kq);
    }
}