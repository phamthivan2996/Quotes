package com.example.phamvan.quotes.QUOTES_FRAGMENT;
import com.example.phamvan.quotes.QUOTES_CUSTOM_ADAPTER.CustomAdapter_Item;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.phamvan.quotes.QUOTES_DB.Beautiful;
import com.example.phamvan.quotes.QUOTES_DB.DaoSession;
import com.example.phamvan.quotes.QUOTES_DB.Family;
import com.example.phamvan.quotes.QUOTES_DB.Friendship;
import com.example.phamvan.quotes.QUOTES_DB.Happiness;
import com.example.phamvan.quotes.QUOTES_DB.HeartSpirit;
import com.example.phamvan.quotes.QUOTES_DB.Knowledge;
import com.example.phamvan.quotes.QUOTES_DB.Love;
import com.example.phamvan.quotes.QUOTES_DB.LoveLife;
import com.example.phamvan.quotes.QUOTES_DB.Man;
import com.example.phamvan.quotes.QUOTES_DB.ManWoman;
import com.example.phamvan.quotes.QUOTES_DB.Marriage;
import com.example.phamvan.quotes.QUOTES_INTERFACE.AllClick;
import com.example.phamvan.quotes.QUOTES_INTERFACE.ApiFBase;
import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;
import com.example.phamvan.quotes.QUOTES_RETROFIT.BeautifulRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.BeautifulRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.FamilyRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.FamilyRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.FriendshipRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.FriendshipRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.HappinessRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.HappinessRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.HeartSpiritRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.HeartSpiritRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.KnowledgeRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.KnowledgeRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.LoveLifeRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.LoveLifeRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.LoveRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.LoveRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.ManRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.ManRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.ManWomanRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.ManWomanRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_RETROFIT.MarriageRetrofit;
import com.example.phamvan.quotes.QUOTES_RETROFIT.MarriageRetrofitReponse;
import com.example.phamvan.quotes.QUOTES_STATIC.JoinDatabase;
import com.example.phamvan.quotes.QUOTES_STATIC.SupportItem;
import com.example.phamvan.quotes.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by PhamVan on 2/2/2017.
 */
public class TopicFragment extends Fragment {
    private ListView lvTopic;
    private List<QuotesObject> listItem = new ArrayList<>();
    private int ID_TABLE;
    private ImageView imAdd;
    private AllClick allClick;
    private AdRequest adRequest;
    private InterstitialAd fullInterstitialAd;
    private CustomAdapter_Item customAdapterItem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        inits(view);
        setValueLvBeautiful();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        allClick = (AllClick) getActivity();
    }

    public void inits(View view) {
        lvTopic = (ListView) view.findViewById(R.id.listViewFragment);
        imAdd = (ImageView) view.findViewById(R.id.icAdd);
    }
    public void setValueLvBeautiful() {
        setListItem();
        setAdapterListView();
        lvTopic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                allClick.clickToMore(listItem.get(i));
            }
        });
        imAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAdmobVideo();
            }
        });
    }

    public void joinFirebase() {
        // Retrofit.... là để kết nối rest trên wep bằng cách chuyển đổi api thành java interface
        // rest là một framework hỗ trợ việc kết nối giữa client vs server thông qua giao thức http hoặc https.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://quarkbackend.com/getfile/kagum2996/")//url of firebase app
                .addConverterFactory(GsonConverterFactory.create())//use for convert JSON file into object
                .build();
        ApiFBase api = retrofit.create(ApiFBase.class);
        switch (ID_TABLE) {
            case 0:
                Call<FriendshipRetrofitReponse> call = api.getFriendShip();
                call.enqueue(new Callback<FriendshipRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<FriendshipRetrofitReponse> call, Response<FriendshipRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            List<FriendshipRetrofit> familyResponse = response.body().getFriendshipRetrofit();
                            Friendship friendship;
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = familyResponse.get(i).getId();
                                author = familyResponse.get(i).getAuthor();
                                sentence = familyResponse.get(i).getSentence();
                                vietnamese = familyResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                friendship = new Friendship(id, author, sentence, vietnamese);
                                daoSession.getFriendshipDao().insert(friendship);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }

                    @Override
                    public void onFailure(Call<FriendshipRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 1:
                Call<BeautifulRetrofitReponse> callBeautiful = api.getBeautiful();
                callBeautiful.enqueue(new Callback<BeautifulRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<BeautifulRetrofitReponse> call, Response<BeautifulRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            List<BeautifulRetrofit> beautifulsResponse = response.body().getBeautifulRetrofit();
                            Beautiful beautiful;
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = beautifulsResponse.get(i).getId();
                                author = beautifulsResponse.get(i).getAuthor();
                                sentence = beautifulsResponse.get(i).getSentence();
                                vietnamese = beautifulsResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                beautiful = new Beautiful(id, author, sentence, vietnamese);
                                daoSession.getBeautifulDao().insert(beautiful);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<BeautifulRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 2:
                Call<FamilyRetrofitReponse> callFamily = api.getFamily();
                callFamily.enqueue(new Callback<FamilyRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<FamilyRetrofitReponse> call, Response<FamilyRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            List<FamilyRetrofit> familyResponse = response.body().getFamilyRetrofit();
                            Family family;
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = familyResponse.get(i).getId();
                                author = familyResponse.get(i).getAuthor();
                                sentence = familyResponse.get(i).getSentence();
                                vietnamese = familyResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                family = new Family(id, author, sentence, vietnamese);
                                daoSession.getFamilyDao().insert(family);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }

                    @Override
                    public void onFailure(Call<FamilyRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 3:
                Call<HappinessRetrofitReponse> callHappiness = api.getHappiness();
                callHappiness.enqueue(new Callback<HappinessRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<HappinessRetrofitReponse> call, Response<HappinessRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            List<HappinessRetrofit> happinessReponse = response.body().getHappinessRetrofit();
                            Happiness happiness;
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = happinessReponse.get(i).getId();
                                author = happinessReponse.get(i).getAuthor();
                                sentence = happinessReponse.get(i).getSentence();
                                vietnamese = happinessReponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                happiness = new Happiness(id, author, sentence, vietnamese);
                                daoSession.getHappinessDao().insert(happiness);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<HappinessRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 4:
                Call<HeartSpiritRetrofitReponse> callHeart = api.getHeartSpirit();
                callHeart.enqueue(new Callback<HeartSpiritRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<HeartSpiritRetrofitReponse> call, Response<HeartSpiritRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            List<HeartSpiritRetrofit> heart = response.body().getHeartSpiritRetrofit();
                            HeartSpirit hearSpirit;
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = heart.get(i).getId();
                                author = heart.get(i).getAuthor();
                                sentence = heart.get(i).getSentence();
                                vietnamese = heart.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                hearSpirit = new HeartSpirit(id, author, sentence, vietnamese);
                                daoSession.getHeartSpiritDao().insert(hearSpirit);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<HeartSpiritRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 5:
                Call<KnowledgeRetrofitReponse> callKnowLedge = api.getKnowledge();
                callKnowLedge.enqueue(new Callback<KnowledgeRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<KnowledgeRetrofitReponse> call, Response<KnowledgeRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            Knowledge knowledge;
                            List<KnowledgeRetrofit> knowledgeResponse = response.body().getKnowledgeRetrofit();
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = knowledgeResponse.get(i).getId();
                                author = knowledgeResponse.get(i).getAuthor();
                                sentence = knowledgeResponse.get(i).getSentence();
                                vietnamese = knowledgeResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                knowledge = new Knowledge(id, author, sentence, vietnamese);
                                daoSession.getKnowledgeDao().insert(knowledge);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<KnowledgeRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 6:
                Call<LoveRetrofitReponse> callLove = api.getLove();
                callLove.enqueue(new Callback<LoveRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<LoveRetrofitReponse> call, Response<LoveRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            Love love;
                            List<LoveRetrofit> loveResponse = response.body().getLoveRetrofit();
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = loveResponse.get(i).getId();
                                author = loveResponse.get(i).getAuthor();
                                sentence = loveResponse.get(i).getSentence();
                                vietnamese = loveResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                love = new Love(null, author, sentence, vietnamese);
                                daoSession.getLoveDao().insert(love);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<LoveRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 7:
                Call<LoveLifeRetrofitReponse> callLoveLife = api.getLoveLife();
                callLoveLife.enqueue(new Callback<LoveLifeRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<LoveLifeRetrofitReponse> call, Response<LoveLifeRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            LoveLife loveLife;
                            List<LoveLifeRetrofit> loveLifeResponse = response.body().getLoveLifeRetrofit();
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = loveLifeResponse.get(i).getId();
                                author = loveLifeResponse.get(i).getAuthor();
                                sentence = loveLifeResponse.get(i).getSentence();
                                vietnamese = loveLifeResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                loveLife = new LoveLife(id, author, sentence, vietnamese);
                                daoSession.getLoveLifeDao().insert(loveLife);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<LoveLifeRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 8:
                Call<ManRetrofitReponse> callMan = api.getMan();
                callMan.enqueue(new Callback<ManRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<ManRetrofitReponse> call, Response<ManRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            Man man;
                            List<ManRetrofit> ManResponse = response.body().getManRetrofit();
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = ManResponse.get(i).getId();
                                author = ManResponse.get(i).getAuthor();
                                sentence = ManResponse.get(i).getSentence();
                                vietnamese = ManResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                man = new Man(id, author, sentence, vietnamese);
                                daoSession.getManDao().insert(man);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<ManRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 9:
                Call<ManWomanRetrofitReponse> callManWoman = api.getManWoman();
                callManWoman.enqueue(new Callback<ManWomanRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<ManWomanRetrofitReponse> call, Response<ManWomanRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            ManWoman manWoman;
                            List<ManWomanRetrofit> manWanResponse = response.body().getManWomanRetrofit();
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = manWanResponse.get(i).getId();
                                author = manWanResponse.get(i).getAuthor();
                                sentence = manWanResponse.get(i).getSentence();
                                vietnamese = manWanResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                manWoman = new ManWoman(id, author, sentence, vietnamese);
                                daoSession.getManWomanDao().insert(manWoman);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<ManWomanRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
            case 10:
                Call<MarriageRetrofitReponse> callMarriage = api.getMarriage();
                callMarriage.enqueue(new Callback<MarriageRetrofitReponse>() {
                    @Override
                    public void onResponse(Call<MarriageRetrofitReponse> call, Response<MarriageRetrofitReponse> response) {
                        try {
                            DaoSession daoSession = JoinDatabase.daoSession;
                            int theNumberOfList = listItem.size();
                            long id;
                            String author, sentence, vietnamese;
                            Marriage marriage;
                            List<MarriageRetrofit> marriageResponse = response.body().getMarriageRetrofit();
                            for (int i = theNumberOfList; i < theNumberOfList + 5; i++) {
                                id = marriageResponse.get(i).getId();
                                author = marriageResponse.get(i).getAuthor();
                                sentence = marriageResponse.get(i).getSentence();
                                vietnamese = marriageResponse.get(i).getVietnamese();
                                listItem.add(new QuotesObject(id, author, sentence, vietnamese));
                                marriage = new Marriage(id, author, sentence, vietnamese);
                                daoSession.getMarriageDao().insert(marriage);
                            }
                            setAdapterListView();
                        } catch (Exception e) {

                        }
                    }
                    @Override
                    public void onFailure(Call<MarriageRetrofitReponse> call, Throwable t) {

                    }
                });
                break;
        }
    }
    public void setAdmobVideo() {
        adRequest = new AdRequest.Builder().build();
        fullInterstitialAd = new InterstitialAd(getActivity());
        fullInterstitialAd.setAdUnitId("ca-app-pub-2070890409282383/7586982351");
        fullInterstitialAd.loadAd(adRequest);
        fullInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                fullInterstitialAd.show();
            }
            @Override
            public void onAdClosed() {
                joinFirebase();
                setAdapterListView();
            }
        });
    }
    private void setListItem() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            ID_TABLE = bundle.getInt("ID_Table");
            DaoSession daoSession = JoinDatabase.daoSession;
            switch (ID_TABLE) {
                case 0:
                    List<Friendship> friendships;
                    friendships = daoSession.getFriendshipDao().loadAll();
                    SupportItem.transferFriendShip(friendships, listItem);
                    break;
                case 1:
                    List<Beautiful> beautifuls;
                    beautifuls = daoSession.getBeautifulDao().loadAll();
                    SupportItem.transferBeautiful(beautifuls, listItem);
                    break;
                case 2:
                    List<Family> families;
                    families = daoSession.getFamilyDao().loadAll();
                    SupportItem.transferFamily(families, listItem);
                    break;
                case 3:
                    List<Happiness> happinesses;
                    happinesses = daoSession.getHappinessDao().loadAll();
                    SupportItem.transferHappiness(happinesses, listItem);
                    break;
                case 4:
                    List<HeartSpirit> heartSpirits;
                    heartSpirits = daoSession.getHeartSpiritDao().loadAll();
                    SupportItem.transferHeartSpirit(heartSpirits, listItem);
                    break;
                case 5:
                    List<Knowledge> knowledges;
                    knowledges = daoSession.getKnowledgeDao().loadAll();
                    SupportItem.transferKnowLedge(knowledges, listItem);
                    break;
                case 6:
                    List<Love> loves;
                    loves = daoSession.getLoveDao().loadAll();
                    SupportItem.transferLove(loves, listItem);
                    break;
                case 7:
                    List<LoveLife> loveLifes;
                    loveLifes = daoSession.getLoveLifeDao().loadAll();
                    SupportItem.transferLoveLife(loveLifes, listItem);
                    break;
                case 8:
                    List<Man> manList;
                    manList = daoSession.getManDao().loadAll();
                    SupportItem.transferMan(manList, listItem);
                    break;
                case 9:
                    List<ManWoman> manWomanList;
                    manWomanList = daoSession.getManWomanDao().loadAll();
                    SupportItem.transferManWoman(manWomanList, listItem);
                    break;
                case 10:
                    List<Marriage> marriages;
                    marriages = daoSession.getMarriageDao().loadAll();
                    SupportItem.transferMarriage(marriages, listItem);
                    break;
            }
        }
    }
    private void setAdapterListView() {
        //customAdapterItem.clear();
        customAdapterItem = new CustomAdapter_Item(getActivity(), R.layout.custom_row_value, listItem);
        lvTopic.setAdapter(customAdapterItem);
    }
}
