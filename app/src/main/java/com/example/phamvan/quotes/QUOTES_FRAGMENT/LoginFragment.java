package com.example.phamvan.quotes.QUOTES_FRAGMENT;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.phamvan.quotes.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.widget.ShareDialog;

/**
 * Created by PhamVan on 2/5/2017.
 */
public class LoginFragment extends Fragment{
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private ShareDialog shareDialog;
    private View v;

    private ImageView imageShare;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getActivity());
        callbackManager = CallbackManager.Factory.create();
        v = inflater.inflate(R.layout.fragment_login_facebook, container, false);
        initsValue();
        setImage();
        shareButton();

        return v;
    }
    public void initsValue() {
        imageShare = (ImageView) v.findViewById(R.id.imageShare);
        loginButton = (LoginButton) v.findViewById(R.id.login_button);

    }
    public void shareButton() {
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getActivity(), "Successful", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getActivity(), "Login attempt canceled.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getActivity(), "Login attempt failed.", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void setImage() {
        Bundle bundle = getArguments();
        Bitmap image = bundle.getParcelable("image_share");
        imageShare.setImageBitmap(image);
    }


}
