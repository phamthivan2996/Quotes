
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarriageRetrofitReponse {

    @SerializedName("MarriageRetrofit")
    @Expose
    private List<MarriageRetrofit> marriageRetrofit = null;

    public List<MarriageRetrofit> getMarriageRetrofit() {
        return marriageRetrofit;
    }

    public void setMarriageRetrofit(List<MarriageRetrofit> marriageRetrofit) {
        this.marriageRetrofit = marriageRetrofit;
    }

}
