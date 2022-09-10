package com.example.doan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doan.R;

public class custom_dialog extends AppCompatActivity {
Button btnok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        btnok=findViewById(R.id.btnOK);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(custom_dialog.this, login_Activity.class);
                startActivity(intent);
            }
        });
    }
}