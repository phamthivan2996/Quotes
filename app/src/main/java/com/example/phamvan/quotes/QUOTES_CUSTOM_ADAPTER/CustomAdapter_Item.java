package com.example.phamvan.quotes.QUOTES_CUSTOM_ADAPTER;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;
import com.example.phamvan.quotes.R;

import java.util.List;

/**
 * Created by PhamVan on 1/26/2017.
 */
public class CustomAdapter_Item extends ArrayAdapter<QuotesObject> {
    private Context context;
    private int resource;
    private List<QuotesObject> quotationObjectJs;
    public CustomAdapter_Item(Context context, int resource, List<QuotesObject> objects) {
        super(context, resource, objects);
        notifyDataSetChanged();
        this.context = context;
        this.resource = resource;
        this.quotationObjectJs = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(resource,parent,false);
        }
        QuotesObject          current =  quotationObjectJs.get(position);
        TextView tvQuotation          = (TextView) view.findViewById(R.id.tvQuotation);
        TextView tvAuthor             = (TextView) view.findViewById(R.id.tvAuthor);
        tvQuotation.setText(current.getSentence());
        tvAuthor.setText(current.getAuthor());

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"ready_for_my_closeup.ttf");
        tvQuotation.setTypeface(typeface);
        tvAuthor.setTypeface(typeface);
        return view;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}
