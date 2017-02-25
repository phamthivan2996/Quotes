
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoveLifeRetrofitReponse {

    @SerializedName("LoveLifeRetrofit")
    @Expose
    private List<LoveLifeRetrofit> loveLifeRetrofit = null;

    public List<LoveLifeRetrofit> getLoveLifeRetrofit() {
        return loveLifeRetrofit;
    }

    public void setLoveLifeRetrofit(List<LoveLifeRetrofit> loveLifeRetrofit) {
        this.loveLifeRetrofit = loveLifeRetrofit;
    }

}
