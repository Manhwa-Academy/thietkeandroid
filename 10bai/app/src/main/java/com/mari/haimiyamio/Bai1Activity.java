package com.mari.haimiyamio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.EditText;

public class Bai1Activity extends AppCompatActivity {

    EditText edtName, edtEmail, edtPass, edtConfirm;
    RadioGroup radioGroup;
    CheckBox cbMusic, cbGame, cbSport;
    Button btnRegister, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        edtConfirm = findViewById(R.id.edtConfirm);
        radioGroup = findViewById(R.id.radioGroup);
        cbMusic = findViewById(R.id.cbMusic);
        cbGame = findViewById(R.id.cbGame);
        cbSport = findViewById(R.id.cbSport);
        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        btnRegister.setOnClickListener(v -> validateAndSubmit());
    }

    private void validateAndSubmit() {

        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String pass = edtPass.getText().toString();
        String confirm = edtConfirm.getText().toString();

        // Kiểm tra rỗng
        if (name.isEmpty()) {
            edtName.setError("Nhập họ tên");
            edtName.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Email không hợp lệ");
            edtEmail.requestFocus();
            return;
        }

        if (pass.length() < 6) {
            edtPass.setError("Mật khẩu tối thiểu 6 ký tự");
            edtPass.requestFocus();
            return;
        }

        if (!pass.equals(confirm)) {
            edtConfirm.setError("Mật khẩu không trùng");
            edtConfirm.requestFocus();
            return;
        }

        int selected = radioGroup.getCheckedRadioButtonId();
        if (selected == -1) {
            showDialog("Vui lòng chọn giới tính");
            return;
        }

        RadioButton rb = findViewById(selected);
        String gender = rb.getText().toString();

        StringBuilder hobby = new StringBuilder();
        if (cbMusic.isChecked()) hobby.append("Âm nhạc, ");
        if (cbGame.isChecked()) hobby.append("Game, ");
        if (cbSport.isChecked()) hobby.append("Thể thao, ");

        String hobbyText = hobby.length() > 0
                ? hobby.substring(0, hobby.length() - 2)
                : "Không có";

        // Chuyển sang màn hình kết quả
        Intent intent = new Intent(this, Bai1ResultActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("gender", gender);
        intent.putExtra("hobby", hobbyText);
        startActivity(intent);
    }

    private void showDialog(String msg) {
        new AlertDialog.Builder(this)
                .setTitle("Thông báo")
                .setMessage(msg)
                .setPositiveButton("OK", null)
                .show();
    }
}