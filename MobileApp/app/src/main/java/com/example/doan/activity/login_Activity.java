package com.example.doan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doan.R;
import com.example.doan.Retrofit.API;
import com.example.doan.Retrofit.Untils;
import com.example.doan.model.users;
import com.example.doan.until.CheckConnection;
import com.example.doan.until.server;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_Activity extends AppCompatActivity {
    Button btnDangNhap, btnDangKy;
    EditText edtEmail, edtMatKhau;
    public static String email1;
    public static String pass;
    public static String iduser;
    TextView forgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(CheckConnection.haveNetworkConnection(getApplicationContext())) {

            AnhXa();
            DangKy();
            login();
           // KiemTraEditText();

        }
        else{
            CheckConnection.ShowToast_Short(getApplicationContext()," Recheck the connection.");
            finish(); }
    }



    private void KiemTraEditText() {
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    edtEmail.setError("You must enter an Email.");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtMatKhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    edtMatKhau.setError("You must enter an password");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

private  void login(){
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String email = edtEmail.getText().toString().trim();
                email1=email;
                String password = edtMatKhau.getText().toString().trim();


                if (!email.equals("") && !password.equals("")) {
                    Toast.makeText(login_Activity.this, "djgheiuhguehg9u", Toast.LENGTH_LONG).show();

                    API dataClient = Untils.getData();
                    retrofit2.Call<String> callback = dataClient.Logindata(email,password);
                    callback.enqueue(new Callback<String>() {


                        @Override
                        public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                            JSONObject jsonObject = new JSONObject();
                        //    if (response.body().equals("1")) {

//                                API data = Untils.getData();
//                                retrofit2.Call<String> call1 = data.getid(email,password);
//                                call1.enqueue(new Callback<String>() {
//                                    @Override
//                                    public void onResponse(Call<String> call, Response<String> response) {
//                                        iduser=response.body();
//
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<String> call, Throwable t) {
//
//                                    }
//                                });
                                Intent intent = new Intent(login_Activity.this, MainActivity.class);
                                startActivity(intent);
                          //  } else {
                             //   Toast.makeText(login_Activity.this, "Incorrect account information.", Toast.LENGTH_LONG).show();

                           // }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });

                    }else{
                    Toast.makeText(login_Activity.this, "Please enter your information.", Toast.LENGTH_LONG).show();
                }
            }
        });
}
    private void DangKy() {
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_Activity.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        btnDangNhap = findViewById(R.id.btn_login);
        btnDangKy = findViewById(R.id.btnRegister);
        edtEmail = findViewById(R.id.inputEmail);
        edtMatKhau = findViewById(R.id.inputPassword);

    }
}