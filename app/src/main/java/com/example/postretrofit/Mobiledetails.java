package com.example.postretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class Mobiledetails extends AppCompatActivity {
    RecyclerView mobil_rv;
    MobileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobiledetails);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        List<Mobile> mobileArrayList = (List<Mobile>)bundle.getSerializable("list");

        mobil_rv = findViewById(R.id.mobile_recycler_view);


        adapter = new MobileAdapter(Mobiledetails.this,mobileArrayList);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(Mobiledetails.this,1);
        mobil_rv.setLayoutManager(linearLayoutManager);
        mobil_rv.setAdapter(adapter);


    }
}
