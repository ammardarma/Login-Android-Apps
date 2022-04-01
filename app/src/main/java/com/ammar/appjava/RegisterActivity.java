package com.ammar.appjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private String usernamereg;
    private String passwordreg;
    private String namaLengkap;
    private String confirmpass;
    private String jenisKelamin;
    private String namaProvinsi;
    private String namaKota;
    private String alamat;

   private EditText formNama;
   private EditText formUsername;
   private EditText formPassword;
   private EditText formConfirmPassword;
   private RadioGroup formJenisKelamin;
   private EditText formAlamat;
   private Button btnRegist;

    String[] provinsi = {"Jawa Barat", "Jawa Tengah", "Jawa Timur", "Kalimantan Barat", "Sumatra Utara"};
    String[] kota = {"Kota Bekasi", "Kota Jakarta", "Kota Bandung", "Kota Lampung", "Kota Cirebon", "Kota Padang", "Kabupaten Bekasi",
    "Kabupaten Cianjur"};


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);
        initView();
    }

    private void initView() {

        formNama = (EditText) findViewById(R.id.namalengkap);
        formUsername = (EditText) findViewById(R.id.username_reg);
        formPassword = (EditText) findViewById(R.id.password_reg);
        formConfirmPassword = (EditText) findViewById(R.id.confirm_pass);
        formJenisKelamin = (RadioGroup) findViewById(R.id.radiogroupjk);
        formAlamat = (EditText) findViewById(R.id.alamat);
        btnRegist = (Button) findViewById(R.id.register_ok);
        btnRegist.setOnClickListener(this);

        Spinner spin = (Spinner) findViewById(R.id.provinsi);
        Spinner spin2 = (Spinner) findViewById(R.id.kota);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter prov = new ArrayAdapter(this, android.R.layout.simple_spinner_item, provinsi);
        prov.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(prov);

        ArrayAdapter kotas = new ArrayAdapter(this, android.R.layout.simple_spinner_item, kota);
        kotas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(kotas);


    }

    @Override
    public void onClick(View v) {

        usernamereg = formUsername.getText().toString();
    passwordreg = formPassword.getText().toString();
    namaLengkap = formNama.getText().toString();
    alamat = formAlamat.getText().toString();
    confirmpass = formConfirmPassword.getText().toString();


        if (v.getId() == R.id.register_ok) {
            if(usernamereg.equals("")) {
                Toast.makeText(getApplicationContext(), "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(passwordreg.equals("")){
                Toast.makeText(getApplicationContext(), "Pasword tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(namaLengkap.equals("")){
                Toast.makeText(getApplicationContext(), "Nama Lengkap tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else if(alamat.equals("")){
                Toast.makeText(getApplicationContext(), "Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(namaProvinsi.equals("")){
                Toast.makeText(getApplicationContext(), "Provinsi tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(namaKota.equals("")){
                Toast.makeText(getApplicationContext(), "Kota tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(confirmpass.equals("")){
                Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(), "Berhasil melakukan pendaftaran!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(intent);
                finish();
            }
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        namaProvinsi = provinsi[position];
        namaKota = kota[position];


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
