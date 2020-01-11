package com.example.infowisatajogja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infowisatajogja.model.BukuPostPutDel;
import com.example.infowisatajogja.network.ApiClient;
import com.example.infowisatajogja.network.BukuService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText edt_sampul, edt_nama, edt_pengarang, edt_tahun, edt_isbn;
    Button btn_insertData, btn_back;
    BukuService bukuService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        edt_sampul = (EditText) findViewById(R.id.edt_sampul);
        edt_nama = (EditText) findViewById(R.id.edt_nama);
        edt_pengarang = (EditText) findViewById(R.id.edt_pengarang);
        edt_tahun = (EditText) findViewById(R.id.edt_tahun);
        edt_isbn = (EditText) findViewById(R.id.edt_isbn);

        bukuService = ApiClient.getRetrofit().create(BukuService.class);
        btn_insertData = (Button) findViewById(R.id.btn_insertData);
        btn_insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<BukuPostPutDel> postBukuCall = bukuService.postBuku(
                        edt_sampul.getText().toString(),
                        edt_nama.getText().toString(),
                        edt_pengarang.getText().toString(),
                        edt_tahun.getText().toString(),
                        edt_isbn.getText().toString()
                );
                postBukuCall.enqueue(new Callback<BukuPostPutDel>() {
                    @Override
                    public void onResponse(Call<BukuPostPutDel> call, Response<BukuPostPutDel> response) {
                        Toast.makeText(getApplicationContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(InsertActivity.this, MainActivity.class));
                }

                    @Override
                    public void onFailure(Call<BukuPostPutDel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsertActivity.this, MainActivity.class));
            }
        });
    }
}
