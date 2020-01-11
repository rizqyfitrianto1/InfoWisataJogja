package com.example.infowisatajogja;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.infowisatajogja.adapter.BukuAdapter;
import com.example.infowisatajogja.adapter.RecyclerAdapter;
import com.example.infowisatajogja.model.Buku;
import com.example.infowisatajogja.model.BukuResult;
import com.example.infowisatajogja.network.ApiClient;
import com.example.infowisatajogja.network.BukuService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btn_tambah;
    ListView listView;
    private static String EXTRA = "extra";
    String pengarang = "";

    //ini pake recycler
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    //sampai sini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ma=this;

        btn_tambah = findViewById(R.id.btn_tambah);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        final EditText edtSearch = (EditText)findViewById(R.id.edt_search);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pengarang = edtSearch.getText().toString().trim();
                loadBuku(pengarang);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loadBuku("");
    }

    private void loadBuku(String pengarang) {
        BukuService service = ApiClient.getRetrofit().create(BukuService.class);
        Call<BukuResult> bukus = service.getBuku(pengarang);
        bukus.enqueue(new Callback<BukuResult>() {
            @Override
            public void onResponse(Call<BukuResult> call, Response<BukuResult> response) {

                List<Buku> BukuList = response.body().getBukus();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(BukuList.size()));
                mAdapter = new RecyclerAdapter(BukuList);
                mRecyclerView.setAdapter(mAdapter);

//                tampilkan(response.body().getBukus());
            }

            @Override
            public void onFailure(Call<BukuResult> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

//    private void tampilkan(List<Buku> bukus) {
//        BukuAdapter bukuAdapter = new BukuAdapter(this, R.layout.item_buku, bukus);
//        listView = (ListView)findViewById(R.id.list_buku);
//        listView.setAdapter(bukuAdapter);
//        bukuAdapter.notifyDataSetChanged();
//    }


}