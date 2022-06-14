package com.ammar.appjava;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private String username;
    private String password;

    private EditText formPassword;
    private EditText formUsername;
    private Button btnLogin;
    private Button btnRegister;
    private CircleImageView imgLogo;
    SharedPreferences sharedPreferences;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        formPassword = (EditText) findViewById(R.id.password);
        formUsername = (EditText) findViewById(R.id.username);
        imgLogo = (CircleImageView) findViewById(R.id.logo);
        btnLogin = (Button) findViewById(R.id.login);
        btnRegister = (Button) findViewById(R.id.register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        if(!username.equals("")){
            formUsername.setText(username);
        }
        if(!password.equals("")){
            formPassword.setText(username);
        }
    }
    @Override
    public void onClick(View v) {

        username = formUsername.getText().toString();
        password = formPassword.getText().toString();

        SharedPreferences.Editor editor = getSharedPreferences("user_details", MODE_PRIVATE).edit();

        if (v.getId() == R.id.login) {
            if(username.equals("")) {
                Toast.makeText(getApplicationContext(), "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(password.equals("")){
                Toast.makeText(getApplicationContext(), "Pasword tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(username.equals("admin") && (password.equals("admin"))){
                Toast.makeText(getApplicationContext(), "Berhasil login!", Toast.LENGTH_SHORT).show();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();
                Intent intent = new Intent(LoginActivity.this, Welcome.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                intent.putExtra("resId", R.drawable.logo);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Username dan Password salah", Toast.LENGTH_SHORT).show();

            }
        } else if(v.getId() == R.id.register){
            Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
            LoginActivity.this.startActivity(intent2);
            finish();
        }
    }
}
