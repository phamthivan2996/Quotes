package com.example.phamvan.quotes.QUOTES_FRAGMENT;


import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.phamvan.quotes.QUOTES_DB.UserNote;
import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;
import com.example.phamvan.quotes.QUOTES_STATIC.JoinDatabase;
import com.example.phamvan.quotes.R;


public class EnterUserNoteFragment extends Fragment implements View.OnClickListener {
    private EditText edNote;
    private ImageView icSave;
    private QuotesObject quote;
    //private View v;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_enter_note, container, false);
        initsValueEnterNote(v);
        setValuesForEnterNote();
        return v;
    }

    public void setValuesForEnterNote() {
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "ready_for_my_closeup.ttf");
        edNote.setTypeface(typeface);

    }
    public void initsValueEnterNote(View view) {
        edNote = (EditText) view.findViewById(R.id.edNote);
        icSave = (ImageView) view.findViewById(R.id.icSave);
        icSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.icSave:
                if(!TextUtils.isEmpty(edNote.getText().toString())) {


                    UserNote userNote = new UserNote();
                    userNote.setSentence(edNote.getText().toString());
                    JoinDatabase.daoSession.insert(userNote);
                    edNote.setText(null);
                }else {

                }
                break;
        }
    }
}
