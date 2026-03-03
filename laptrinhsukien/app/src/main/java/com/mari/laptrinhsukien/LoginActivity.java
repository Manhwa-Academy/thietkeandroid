package com.mari.laptrinhsukien;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity {

    EditText edtUser, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView imgLogo = findViewById(R.id.imgLogo);

        Glide.with(this)
                .asGif()
                .load(R.drawable.low)
                .into(imgLogo);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);

        findViewById(R.id.btnLogin).setOnClickListener(v -> {

            String user = edtUser.getText().toString().trim();
            String pass = edtPass.getText().toString().trim();

            if(user.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                return;
            }

            if(user.equals("admin") && pass.equals("123456")){
                startActivity(new Intent(this, MenuActivity.class));
                finish();
            }else{
                Toast.makeText(this,"Sai thông tin đăng nhập",Toast.LENGTH_SHORT).show();
            }
        });
    }
}