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

public class EditActivity extends AppCompatActivity {
    EditText edt_id, edt_sampul, edt_nama, edt_pengarang, edt_tahun, edt_isbn;
    Button btn_update, btn_delete, btn_back;
    BukuService bukuService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_sampul = (EditText) findViewById(R.id.edt_sampul);
        edt_nama = (EditText) findViewById(R.id.edt_nama);
        edt_pengarang = (EditText) findViewById(R.id.edt_pengarang);
        edt_tahun = (EditText) findViewById(R.id.edt_tahun);
        edt_isbn = (EditText) findViewById(R.id.edt_isbn);

        Intent mIntent = getIntent();

        edt_id.setText(mIntent.getStringExtra("id"));
        edt_id.setTag(edt_id.getKeyListener());
        edt_id.setKeyListener(null);
        edt_sampul.setText(mIntent.getStringExtra("sampul"));
        edt_nama.setText(mIntent.getStringExtra("nama"));
        edt_pengarang.setText(mIntent.getStringExtra("pengarang"));
        edt_tahun.setText(mIntent.getStringExtra("tahun_terbit"));
        edt_isbn.setText(mIntent.getStringExtra("isbn"));

        bukuService = ApiClient.getRetrofit().create(BukuService.class);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<BukuPostPutDel> updateBukuCall = bukuService.putBuku(
                        edt_id.getText().toString(),
                        edt_sampul.getText().toString(),
                        edt_nama.getText().toString(),
                        edt_pengarang.getText().toString(),
                        edt_tahun.getText().toString(),
                        edt_isbn.getText().toString()
                        );
                updateBukuCall.enqueue(new Callback<BukuPostPutDel>() {
                    @Override
                    public void onResponse(Call<BukuPostPutDel> call, Response<BukuPostPutDel> response) {
                        Toast.makeText(getApplicationContext(), "Data berhasil diupdate", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(EditActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onFailure(Call<BukuPostPutDel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_id.getText().toString().trim().isEmpty()==false){
                    Call<BukuPostPutDel> deleteBuku = bukuService.deleteBuku(edt_id.getText().toString());
                    deleteBuku.enqueue(new Callback<BukuPostPutDel>() {
                        @Override
                        public void onResponse(Call<BukuPostPutDel> call, Response<BukuPostPutDel> response) {
                            Toast.makeText(getApplicationContext(), "Data berhasil dihapus", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(EditActivity.this, MainActivity.class));
                        }

                        @Override
                        public void onFailure(Call<BukuPostPutDel> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditActivity.this, MainActivity.class));
            }
        });
    }
}
