
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeautifulRetrofitReponse {

    @SerializedName("BeautifulRetrofit")
    @Expose
    private List<BeautifulRetrofit> beautifulRetrofit = null;

    public List<BeautifulRetrofit> getBeautifulRetrofit() {
        return beautifulRetrofit;
    }

    public void setBeautifulRetrofit(List<BeautifulRetrofit> beautifulRetrofit) {
        this.beautifulRetrofit = beautifulRetrofit;
    }

}
