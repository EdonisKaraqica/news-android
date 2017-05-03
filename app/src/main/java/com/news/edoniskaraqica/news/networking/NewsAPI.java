package com.news.edoniskaraqica.news.networking;

import com.news.edoniskaraqica.news.model.GetArticlesResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

/**
 * Created by Edonis Karaçica on 3/27/2017.
 */

public class NewsAPI {
    private static final String APIKEY="12de349c02004428898d4e2b9649ef73";
    private static final String APIPATH="http://edonisk.com/";

    private static NewsService newsService=null;

    public static NewsService getApi(){
        if (newsService==null){
            //initialize NewsService
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(APIPATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsService=retrofit.create(NewsService.class);
        }
        return newsService;
    }


    public interface NewsService {
        @Headers({
                "Accept: application/vnd.github.v3.full+json",
                "User-Agent: Retrofit-Sample-App"
        })

        @GET("autoret1.php")
        Call<GetArticlesResponse> getArticles();
    }
}
