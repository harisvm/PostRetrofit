package com.example.postretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mobile> mobileArrayList;
    EditText name;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = findViewById(R.id.editText);
                String str_name = name.getText().toString();

                MobileApi mobileApi = RetrofitClient.getRetrofitInstance().create(MobileApi.class);

                Call<JsonObject> call = mobileApi.getMobileApiInfo(str_name);

                call.enqueue(new Callback<JsonObject>() {


                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        JsonObject responseObject = response.body();
                        JsonArray dataarray = responseObject.getAsJsonArray("data");
                        mobileArrayList = getGeneral(dataarray.toString());
                        generateDataList(mobileArrayList);

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });

            }
            private ArrayList<Mobile> getGeneral(String s) {

               Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Mobile>>() {
                }.getType();
                return gson.fromJson(s,listType);
            }
            private void generateDataList(ArrayList<Mobile> mobileList) {

                Intent in = new Intent(getApplicationContext(), Mobiledetails.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", mobileList);
                in.putExtras(bundle);
                startActivity(in);

            }

        });

    }
}
