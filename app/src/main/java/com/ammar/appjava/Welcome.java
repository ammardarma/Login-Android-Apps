package com.ammar.appjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
    Button btnExit;
    TextView labelUsername;
    Button btnBelajar;
    ImageView imgLogo;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);
    btnExit = (Button) findViewById(R.id.logout);
    imgLogo = (ImageView) findViewById(R.id.logoo);
    btnExit.setOnClickListener(this);
    btnBelajar = (Button) findViewById(R.id.belajar);
    btnBelajar.setOnClickListener(this);

    labelUsername = findViewById(R.id.sapaUsername);

    if(getIntent().getExtras() != null) {
        Bundle bundle = getIntent().getExtras();
        int resId = bundle.getInt("resId");
        imgLogo.setImageResource(resId);
        labelUsername.setText("Selamat Datang " + bundle.getString("username") + " " +bundle.getString("password"));
    }

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.logout) {
            Intent intent = new Intent(Welcome.this, LoginActivity.class);
            Welcome.this.startActivity(intent);
            finish();
        }else if(v.getId() == R.id.belajar) {
            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kode.id/"));
            startActivity(intent2);
        }
    }
}
