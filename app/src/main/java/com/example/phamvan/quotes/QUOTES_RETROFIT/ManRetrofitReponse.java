
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ManRetrofitReponse {

    @SerializedName("ManRetrofit")
    @Expose
    private List<ManRetrofit> manRetrofit = null;

    public List<ManRetrofit> getManRetrofit() {
        return manRetrofit;
    }

    public void setManRetrofit(List<ManRetrofit> manRetrofit) {
        this.manRetrofit = manRetrofit;
    }

}
