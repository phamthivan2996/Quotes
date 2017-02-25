
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FamilyRetrofitReponse {

    @SerializedName("FamilyRetrofit")
    @Expose
    private List<FamilyRetrofit> familyRetrofit = null;

    public List<FamilyRetrofit> getFamilyRetrofit() {
        return familyRetrofit;
    }

    public void setFamilyRetrofit(List<FamilyRetrofit> familyRetrofit) {
        this.familyRetrofit = familyRetrofit;
    }

}
