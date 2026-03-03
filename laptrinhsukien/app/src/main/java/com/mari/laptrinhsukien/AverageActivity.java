package com.mari.laptrinhsukien;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class AverageActivity extends AppCompatActivity {

    EditText edtToan, edtVan, edtAnh;
    TextView txtAvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average);

        edtToan = findViewById(R.id.edtToan);
        edtVan = findViewById(R.id.edtVan);
        edtAnh = findViewById(R.id.edtAnh);
        txtAvg = findViewById(R.id.txtAvg);

        findViewById(R.id.btnTinh).setOnClickListener(v -> tinh());
        findViewById(R.id.btnClear).setOnClickListener(v -> clear());
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }

    private void tinh() {

        if (edtToan.getText().toString().isEmpty() ||
                edtVan.getText().toString().isEmpty() ||
                edtAnh.getText().toString().isEmpty()) {

            txtAvg.setText("Vui lòng nhập đầy đủ dữ liệu");
            return;
        }

        double toan = Double.parseDouble(edtToan.getText().toString());
        double van = Double.parseDouble(edtVan.getText().toString());
        double anh = Double.parseDouble(edtAnh.getText().toString());

        if (toan < 0 || toan > 10 ||
                van < 0 || van > 10 ||
                anh < 0 || anh > 10) {

            txtAvg.setText("Điểm không hợp lệ (0–10)");
            return;
        }

        double avg = (toan + van + anh) / 3;

        txtAvg.setText(String.format("Điểm trung bình: %.2f", avg));
    }

    private void clear() {
        edtToan.setText("");
        edtVan.setText("");
        edtAnh.setText("");
        txtAvg.setText("Kết quả:");
    }
}