package com.example.phamvan.quotes.QUOTES_CUSTOM_ADAPTER;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.phamvan.quotes.QUOTES_OBJECTS.MainObject;
import com.example.phamvan.quotes.R;

import java.util.ArrayList;

/**
 * Created by PhamVan on 1/24/2017.
 */
public class CustomAdapter_Main extends ArrayAdapter<MainObject> {
    private Context context;
    private int resource;
    private ArrayList<MainObject> listTopic;
    public CustomAdapter_Main(Context context, int resource, ArrayList<MainObject> objects) {
        super(context, resource, objects);
        this.listTopic =  objects;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view ==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);
        }
        MainObject currentTopic = listTopic.get(position);

        TextView tvTopic = (TextView) view.findViewById(R.id.tvTopic);
        ImageView imageTopic = (ImageView) view.findViewById(R.id.imageTopic);


        tvTopic.setText(currentTopic.getTvNameTopic());
        imageTopic.setImageResource(currentTopic.getImageIDTopic());
        //set font
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "ufonts_com_century.ttf");
        tvTopic.setTypeface(typeface);
        return view;
    }
}
