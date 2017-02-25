
package com.example.phamvan.quotes.QUOTES_RETROFIT;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FriendshipRetrofitReponse {

    @SerializedName("FriendshipRetrofit")
    @Expose
    private List<FriendshipRetrofit> friendshipRetrofit = null;

    public List<FriendshipRetrofit> getFriendshipRetrofit() {
        return friendshipRetrofit;
    }

    public void setFriendshipRetrofit(List<FriendshipRetrofit> friendshipRetrofit) {
        this.friendshipRetrofit = friendshipRetrofit;
    }

}
