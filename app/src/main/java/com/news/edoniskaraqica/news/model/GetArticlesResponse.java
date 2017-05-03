
package com.news.edoniskaraqica.news.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetArticlesResponse {


    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;



    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
