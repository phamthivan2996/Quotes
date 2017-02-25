
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeartSpiritRetrofitReponse {

    @SerializedName("HeartSpiritRetrofit")
    @Expose
    private List<HeartSpiritRetrofit> heartSpiritRetrofit = null;

    public List<HeartSpiritRetrofit> getHeartSpiritRetrofit() {
        return heartSpiritRetrofit;
    }

    public void setHeartSpiritRetrofit(List<HeartSpiritRetrofit> heartSpiritRetrofit) {
        this.heartSpiritRetrofit = heartSpiritRetrofit;
    }

}
