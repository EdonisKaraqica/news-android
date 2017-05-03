package com.news.edoniskaraqica.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.news.edoniskaraqica.news.model.GetArticlesResponse;
import com.news.edoniskaraqica.news.networking.NewsAPI;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleDateFormat smpData=new SimpleDateFormat("hh:mm");



        newsRecyclerView=(RecyclerView)findViewById(R.id.activity_main_recyclerview);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        retrofit2.Call<GetArticlesResponse> call;
        call = NewsAPI.getApi().getArticles();
        //call mundet mu thirr sinkronsilli ose asinkronislli, po masi e thirrim prej thredit kryesor atehere eshte asinkroslli
        call.enqueue(new Callback<GetArticlesResponse>() {
            @Override
            public void onResponse(retrofit2.Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {
                GetArticlesResponse getArticlesResponse=response.body();
                NewsStore.setNewsArticles(getArticlesResponse.getArticles());
                Toast.makeText(MainActivity.this,"Response received",Toast.LENGTH_SHORT).show();
                HomeNewsAdapter homeNewsAdapter=new HomeNewsAdapter(getArticlesResponse.getArticles());
                newsRecyclerView.setAdapter(homeNewsAdapter);
            }

            @Override
            public void onFailure(retrofit2.Call<GetArticlesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error received",Toast.LENGTH_SHORT).show();

            }
        });



    }
}
