package com.example.phamvan.quotes.QUOTES_FRAGMENT;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.phamvan.quotes.QUOTES_DB.DaoMaster;
import com.example.phamvan.quotes.QUOTES_DB.DaoSession;
import com.example.phamvan.quotes.QUOTES_DB.UserLike;
import com.example.phamvan.quotes.QUOTES_INTERFACE.AllClick;
import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;
import com.example.phamvan.quotes.QUOTES_DATABASE.QuotesDB;
import com.example.phamvan.quotes.QUOTES_STATIC.JoinDatabase;
import com.example.phamvan.quotes.R;

import com.facebook.FacebookSdk;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.util.List;


public class MoreValueFragment extends Fragment implements View.OnClickListener {
    private TextView tvSentence;
    private TextView tvVietnamese;
    private TextView tvAuthorQT;
    private ImageView imLike;
    private ImageView imShare;
    private ImageView imFaceBook;
    private QuotesObject quote;
    private Boolean likeCheck = false;
    private LinearLayout screen;
    private AllClick allClick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getActivity());
        View v = inflater.inflate(R.layout.fragment_more_value, container, false);
        initsValues(v);
        setValuesForAC();
        setImageLike();
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        allClick = (AllClick) getActivity();
    }

    public void setValuesForAC() {
        //get values from listview when click on item
        Bundle bundleItem = getArguments();
        quote = (QuotesObject) bundleItem.getSerializable("Quote");
        tvSentence.setText(quote.getSentence());
        tvVietnamese.setText(quote.getVietnamese());
        tvAuthorQT.setText(quote.getAuthor());

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "ready_for_my_closeup.ttf");
        tvSentence.setTypeface(typeface);
        tvVietnamese.setTypeface(typeface);
        tvAuthorQT.setTypeface(typeface);

    }
    public void initsValues(View view) {
        tvSentence = (TextView) view.findViewById(R.id.tvSentence);
        tvVietnamese = (TextView) view.findViewById(R.id.tvVietnamese);
        tvAuthorQT = (TextView) view.findViewById(R.id.tvAuthorQT);
        imLike = (ImageView) view.findViewById(R.id.icMoreLike);
        imShare = (ImageView) view.findViewById(R.id.icMoreShare);
        imFaceBook = (ImageView) view.findViewById(R.id.icFacebook);
        screen = (LinearLayout) view.findViewById(R.id.layout_contains);
        imLike.setOnClickListener(this);
        imShare.setOnClickListener(this);
        imFaceBook.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        UserLike userLike1 = new UserLike(null,quote.getAuthor(),quote.getSentence(),quote.getVietnamese());
        UserLike userLike2 = new UserLike(quote.getId(),quote.getAuthor(),quote.getSentence(),quote.getVietnamese());
        switch (view.getId()) {
            case R.id.icMoreLike:
                DaoSession daoSession = JoinDatabase.daoSession;
                if (likeCheck == false) {
                    imLike.setImageResource(R.drawable.love_red);
                    daoSession.getUserLikeDao().insert(userLike1);
                    likeCheck = true;
                } else {
                    imLike.setImageResource(R.drawable.love_icon);
                    daoSession.getUserLikeDao().delete(userLike2);
                    likeCheck = false;
                }
                break;
            case R.id.icMoreShare:
                shareimage();
                break;
            case R.id.icFacebook:
                shareToFaceBook();
                break;
        }
    }

    public void setImageLike() {

        QuotesDB quotesDB = new QuotesDB(getActivity());
        SQLiteDatabase db = quotesDB.getSQLiteDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        List<UserLike> userLikes = daoSession.getUserLikeDao().loadAll();
        for(int i = 0; i< userLikes.size(); i++){
            if (quote.getSentence().equals(userLikes.get(i).getSentence())) {
                imLike.setImageResource(R.drawable.love_red);
                likeCheck = true;
            }
        }
    }

    public void shareToFaceBook(){
        //FacebookSdk.sdkInitialize(getActivity()); cần phải có dòng này ở trên setContenView()
        // đoạn này dùng chụp ảnh
        allClick.setAdsFull();
        Bitmap image = Bitmap.createBitmap(screen.getWidth(), screen.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas b = new Canvas(image);
        screen.draw(b);

        ShareDialog facebookDialog = new ShareDialog(getActivity());
        if(ShareDialog.canShow(SharePhotoContent.class)) {
            SharePhoto photo = new SharePhoto.Builder()
                    .setCaption("#Quotes")
                    .setBitmap(Bitmap.createBitmap(image))
                    .build();
            SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();
            facebookDialog.show(content);
        }else {

        }
    }
    public void shareimage() {
        Bitmap image = Bitmap.createBitmap(screen.getWidth(), screen.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas b = new Canvas(image);
        screen.draw(b);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        String bitmapPath = MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), image,"title", null);
        Uri bitmapUri = Uri.parse(bitmapPath);
        intent.putExtra(Intent.EXTRA_STREAM, bitmapUri );
        startActivity(Intent.createChooser(intent ,"Share"));
    }
}
