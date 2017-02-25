package com.example.phamvan.quotes.QUOTES_FRAGMENT;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.phamvan.quotes.QUOTES_DB.UserNote;
import com.example.phamvan.quotes.QUOTES_INTERFACE.AllClick;
import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;
import com.example.phamvan.quotes.QUOTES_CUSTOM_ADAPTER.CustomAdapter_Item;
import com.example.phamvan.quotes.QUOTES_STATIC.JoinDatabase;
import com.example.phamvan.quotes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhamVan on 2/1/2017.
 */
public class NoteFragment extends Fragment {
    public ListView noteLv;
    private List<UserNote> listNote;
    private AllClick allClick;
    private ImageView icAdd;
    private QuotesObject quote;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview,container,false);
        inits(view);
        setValuesForNoteLv();
        setLongPressItem();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listNote = null;
        quote = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        allClick = (AllClick) getActivity();
    }

    public void inits(View view) {
        noteLv = (ListView) view.findViewById(R.id.listViewFragment);
        icAdd = (ImageView) view.findViewById(R.id.icAdd);
        icAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                EnterUserNoteFragment enterNote = new EnterUserNoteFragment();
                fragmentTransaction.replace(R.id.LinearForFragment,enterNote);
                fragmentTransaction.addToBackStack("enterNote");
                fragmentTransaction.commit();
            }
        });
    }

    public void setValuesForNoteLv(){
        getAllValueNote();

        List<QuotesObject> quotes = new ArrayList<>();
        transfreData(quotes);

        CustomAdapter_Item customAdapterItem = new CustomAdapter_Item(getActivity(), R.layout.custom_row_value,quotes);
        noteLv.setAdapter(customAdapterItem);

        noteLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Long id = listNote.get(i).getId();
                String sentence = listNote.get(i).getSentence();
                quote = new QuotesObject(id,sentence);
                allClick.clickToMore(quote);
            }
        });
    }
    public void transfreData(List<QuotesObject> quotes) {
        String sentence;
        Long id;
        for(int i =0;i<listNote.size();i++) {
            id = listNote.get(i).getId();
            sentence = listNote.get(i).getSentence();
            quotes.add(new QuotesObject(id,sentence));
        }
    }
    public void getAllValueNote() {
        listNote = JoinDatabase.daoSession.getUserNoteDao().loadAll();
    }

    public void setLongPressItem() {
        noteLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setCancelable(false);
                dialog.setTitle("Notification");
                dialog.setMessage("Are you sure you want to delete it?" );
                final int position = i;
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        JoinDatabase.daoSession.getUserNoteDao().delete(listNote.get(position));

                        FragmentManager fragmentManager = getActivity().getFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();

                        NoteFragment fragmentNote = new NoteFragment();
                        transaction.replace(R.id.LinearForFragment, fragmentNote);
                        transaction.addToBackStack("Note");
                        transaction.commit();
                    }
                })
                        .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Action for "Cancel".
                            }
                        });

                final AlertDialog alert = dialog.create();
                alert.show();

                return false;
            }
        });
    }
}
