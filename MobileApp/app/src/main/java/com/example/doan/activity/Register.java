package com.example.doan.activity;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doan.R;
import com.example.doan.Retrofit.API;
import com.example.doan.Retrofit.Untils;
import com.example.doan.until.CheckConnection;
import com.example.doan.until.server;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;

public class Register extends AppCompatActivity {

    Button btnDangky,btnexit;
    EditText edtTenKhachHang, edtEmailDK, edtMatKhau, edtNhapLaiMatKhau;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if(CheckConnection.haveNetworkConnection(getApplicationContext())) {

           AnhXa();
           KiemTraEditText();
           // register();


        }
        else{
            CheckConnection.ShowToast_Short(getApplicationContext()," Recheck the connection.");
            finish(); }
    }

    private void KiemTraEditText() {
        edtMatKhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    edtMatKhau.setError("You must enter an password.");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtNhapLaiMatKhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    edtNhapLaiMatKhau.setError("You must enter an confirm password");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtEmailDK.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    edtEmailDK.setError("You must enter an Email");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtTenKhachHang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    edtTenKhachHang.setError("You must enter an Name");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

//private void register(){
//        btnDangky.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String hoTen = edtTenKhachHang.getText().toString().trim();
//                String email = edtEmailDK.getText().toString().trim();
//                String matkhau = edtMatKhau.getText().toString().trim();
//                String nhaplaimatkhau = edtNhapLaiMatKhau.getText().toString().trim();
//                if (!matkhau.equals(nhaplaimatkhau)) {
//                    Toast.makeText(Register.this, "Re-entered passwords do not match.", Toast.LENGTH_LONG).show();
//                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                    Toast.makeText(Register.this, "Incorrect email format.", Toast.LENGTH_LONG).show();
//                } else if (!hoTen.equals("") && !email.equals("") && !matkhau.equals("")) {
//                    API dataClient = Untils.getData();
//                    retrofit2.Call<String> callback = dataClient.InsertData(hoTen, email, matkhau);
//                    callback.enqueue(new Callback<String>() {
//                        @Override
//                        public void onResponse(Call<String> call, retrofit2.Response<String> response) {
//                            if (response != null) {
//                                String message = response.body();
//                               if (message.length() > 0) {
//                                   if (message.equals("1")) {
//                                       Intent intent = new Intent(Register.this, custom_dialog.class);
//                                       startActivity(intent);
//                                   } else {
//                                       Toast.makeText(Register.this, "This email is already in use for another account.", Toast.LENGTH_LONG).show();
//                                   }
//                               }
//
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<String> call, Throwable t) {
//
//                        }
//                    });
//
//
//                } else {
//                    Toast.makeText(Register.this, "Please enter full information.", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//}
    private void AnhXa() {
        btnDangky = findViewById(R.id.btnRegister);
        edtTenKhachHang = findViewById(R.id.inputName);
        edtEmailDK = findViewById(R.id.inputEmail);
        edtMatKhau = findViewById(R.id.inputPassword);
        edtNhapLaiMatKhau = findViewById(R.id.inputconfirm);

    }
}
