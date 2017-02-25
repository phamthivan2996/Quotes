
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoveRetrofitReponse {

    @SerializedName("LoveRetrofit")
    @Expose
    private List<LoveRetrofit> loveRetrofit = null;

    public List<LoveRetrofit> getLoveRetrofit() {
        return loveRetrofit;
    }

    public void setLoveRetrofit(List<LoveRetrofit> loveRetrofit) {
        this.loveRetrofit = loveRetrofit;
    }

}
