
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KnowledgeRetrofitReponse {

    @SerializedName("KnowledgeRetrofit")
    @Expose
    private List<KnowledgeRetrofit> knowledgeRetrofit = null;

    public List<KnowledgeRetrofit> getKnowledgeRetrofit() {
        return knowledgeRetrofit;
    }

    public void setKnowledgeRetrofit(List<KnowledgeRetrofit> knowledgeRetrofit) {
        this.knowledgeRetrofit = knowledgeRetrofit;
    }

}
