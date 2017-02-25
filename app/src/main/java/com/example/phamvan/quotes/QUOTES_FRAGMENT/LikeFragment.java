package com.example.phamvan.quotes.QUOTES_FRAGMENT;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.phamvan.quotes.QUOTES_DB.UserLike;
import com.example.phamvan.quotes.QUOTES_INTERFACE.AllClick;
import com.example.phamvan.quotes.QUOTES_CUSTOM_ADAPTER.CustomAdapter_Item;
import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;
import com.example.phamvan.quotes.QUOTES_STATIC.JoinDatabase;
import com.example.phamvan.quotes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhamVan on 2/1/2017.
 */
public class LikeFragment extends Fragment  {
    public ListView likeLv;
    private List<UserLike> listLike;
    private AllClick allClick;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        inits(view);
        setValuesForLikeLv();
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        allClick = (AllClick) getActivity();
    }

    public void inits(View view) {
        likeLv = (ListView) view.findViewById(R.id.lv_fragmentHome);
    }
    public void setValuesForLikeLv(){
        getAllValueLike();

        List<QuotesObject> quotes = new ArrayList<>();
        transfreData(quotes);
        CustomAdapter_Item customAdapterItem = new CustomAdapter_Item(getActivity(), R.layout.custom_row_value,quotes);
        likeLv.setAdapter(customAdapterItem);

        likeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Long id = listLike.get(i).getId();
                String author = listLike.get(i).getAuthor();
                String sentence = listLike.get(i).getSentence();
                String vietnamese = listLike.get(i).getVietnamese();
                QuotesObject quote = new QuotesObject(id,author,sentence,vietnamese);
                allClick.clickToMore(quote);
            }
        });
    }
    public void transfreData(List<QuotesObject> quotes) {
        for(int i =0;i<listLike.size();i++) {
            Long id = listLike.get(i).getId();
            String author = listLike.get(i).getAuthor();
            String sentence = listLike.get(i).getSentence();
            String vietnamese = listLike.get(i).getVietnamese();
            quotes.add(new QuotesObject(id,author,sentence,vietnamese));
        }
    }

    public void getAllValueLike() {
        listLike = JoinDatabase.daoSession.getUserLikeDao().loadAll();
    }

}
