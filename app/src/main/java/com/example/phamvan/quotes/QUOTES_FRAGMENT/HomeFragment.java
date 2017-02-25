package com.example.phamvan.quotes.QUOTES_FRAGMENT;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.phamvan.quotes.QUOTES_OBJECTS.MainObject;
import com.example.phamvan.quotes.QUOTES_CUSTOM_ADAPTER.CustomAdapter_Main;
import com.example.phamvan.quotes.R;

import java.util.ArrayList;

/**
 * Created by PhamVan on 2/2/2017.
 */
public class HomeFragment extends Fragment {
    public ListView listViewOne;
    private ArrayList<MainObject> listTopic;

    private int[] idImage = {R.drawable.friendship,R.drawable.beautiful,R.drawable.family, R.drawable.happiness,
            R.drawable.heart_siprit,R.drawable.knowledge, R.drawable.love,
            R.drawable.love_life,R.drawable.man,R.drawable.manwoman,R.drawable.marriage};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        findIDs(view);
        setValuesInListViewOne();
        return view;
    }
    public void findIDs(View view) {
        listViewOne = (ListView) view.findViewById(R.id.lv_fragmentHome);

    }
    public void setValuesInListViewOne(){

        listTopic = new ArrayList<>();
        listTopic.add(new MainObject(idImage[0],"Friendship"));
        listTopic.add(new MainObject(idImage[1],"Beautiful "));
        listTopic.add(new MainObject(idImage[2],"Family"));
        listTopic.add(new MainObject(idImage[3],"Happiness"));
        listTopic.add(new MainObject(idImage[4],"The Heart - Spirit"));
        listTopic.add(new MainObject(idImage[5],"Knowledge"));
        listTopic.add(new MainObject(idImage[6],"Love"));
        listTopic.add(new MainObject(idImage[7],"Love and Life"));
        listTopic.add(new MainObject(idImage[8],"Man"));
        listTopic.add(new MainObject(idImage[9],"Man and Woman"));
        listTopic.add(new MainObject(idImage[10],"Marriage"));

        CustomAdapter_Main customAdapterMyTopic  = new CustomAdapter_Main(getActivity(),R.layout.custom_row_name_topic,listTopic);
        listViewOne.setAdapter(customAdapterMyTopic);
        listViewOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                makeTableName(i);
            }
        });
    }
    public void makeTableName(int position) {

        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        int ID_TABLE = position;
        TopicFragment topicFragment = new TopicFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("ID_Table",ID_TABLE);
        topicFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.LinearForFragment,topicFragment);
        fragmentTransaction.addToBackStack("Topic");
        fragmentTransaction.commit();
    }



}
