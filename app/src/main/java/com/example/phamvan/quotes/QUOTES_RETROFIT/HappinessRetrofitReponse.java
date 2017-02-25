
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HappinessRetrofitReponse {

    @SerializedName("HappinessRetrofit")
    @Expose
    private List<HappinessRetrofit> happinessRetrofit = null;

    public List<HappinessRetrofit> getHappinessRetrofit() {
        return happinessRetrofit;
    }

    public void setHappinessRetrofit(List<HappinessRetrofit> happinessRetrofit) {
        this.happinessRetrofit = happinessRetrofit;
    }

}
