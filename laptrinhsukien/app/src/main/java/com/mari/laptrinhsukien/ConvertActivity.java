package com.mari.laptrinhsukien;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class ConvertActivity extends AppCompatActivity {

    EditText edtInput;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        edtInput = findViewById(R.id.edtInput);
        txtResult = findViewById(R.id.txtResult);

        findViewById(R.id.btnCtoF).setOnClickListener(v -> doiCtoF());
        findViewById(R.id.btnFtoC).setOnClickListener(v -> doiFtoC());
        findViewById(R.id.btnClear).setOnClickListener(v -> clear());
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }

    private void doiCtoF() {
        if (edtInput.getText().toString().isEmpty()) {
            txtResult.setText("Vui lòng nhập dữ liệu");
            return;
        }

        double c = Double.parseDouble(edtInput.getText().toString());
        double f = c * 1.8 + 32;

        txtResult.setText("F = " + f);
    }

    private void doiFtoC() {
        if (edtInput.getText().toString().isEmpty()) {
            txtResult.setText("Vui lòng nhập dữ liệu");
            return;
        }

        double f = Double.parseDouble(edtInput.getText().toString());
        double c = (f - 32) / 1.8;

        txtResult.setText("C = " + c);
    }

    private void clear() {
        edtInput.setText("");
        txtResult.setText("Kết quả:");
    }
}