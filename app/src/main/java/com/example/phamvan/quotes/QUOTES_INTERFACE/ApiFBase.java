package com.example.phamvan.quotes.QUOTES_INTERFACE;

import com.example.phamvan.quotes.QUOTES_RETROFIT.BeautifulRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.FamilyRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.FriendshipRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.HappinessRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.HeartSpiritRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.KnowledgeRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.LoveLifeRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.LoveRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.ManRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.ManWomanRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.MarriageRetrofitReponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by PhamVan on 2/14/2017.
 */
public interface ApiFBase {
    @GET("beautiful")

    Call<BeautifulRetrofitReponse> getBeautiful();
    @GET("love")
    Call<LoveRetrofitReponse> getLove();
    @GET("family")
    Call<FamilyRetrofitReponse> getFamily();
    @GET("friendship")
    Call<FriendshipRetrofitReponse> getFriendShip();
    @GET("happiness")
    Call<HappinessRetrofitReponse> getHappiness();
    @GET("heart-spirit")
    Call<HeartSpiritRetrofitReponse> getHeartSpirit();
    @GET("knowledge")
    Call<KnowledgeRetrofitReponse> getKnowledge();
    @GET("love-life")
    Call<LoveLifeRetrofitReponse> getLoveLife();
    @GET("man")
    Call<ManRetrofitReponse> getMan();
    @GET("man-woman")
    Call<ManWomanRetrofitReponse> getManWoman();
    @GET("marriage")
    Call<MarriageRetrofitReponse> getMarriage();
}
