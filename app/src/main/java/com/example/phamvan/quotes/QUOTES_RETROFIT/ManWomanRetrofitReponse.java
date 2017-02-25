
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ManWomanRetrofitReponse {

    @SerializedName("ManWomanRetrofit")
    @Expose
    private List<ManWomanRetrofit> manWomanRetrofit = null;

    public List<ManWomanRetrofit> getManWomanRetrofit() {
        return manWomanRetrofit;
    }

    public void setManWomanRetrofit(List<ManWomanRetrofit> manWomanRetrofit) {
        this.manWomanRetrofit = manWomanRetrofit;
    }

}
