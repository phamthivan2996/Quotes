package com.example.phamvan.quotes.QUOTES_ACTIVITY;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.phamvan.quotes.QUOTES_FRAGMENT.HomeFragment;
import com.example.phamvan.quotes.QUOTES_FRAGMENT.LikeFragment;

import com.example.phamvan.quotes.QUOTES_FRAGMENT.MoreValueFragment;
import com.example.phamvan.quotes.QUOTES_FRAGMENT.NoteFragment;
import com.example.phamvan.quotes.QUOTES_INTERFACE.AllClick;
import com.example.phamvan.quotes.QUOTES_NOTIFICATIONS.QuotesNotifications;
import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;
import com.example.phamvan.quotes.QUOTES_STATIC.JoinDatabase;
import com.example.phamvan.quotes.R;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


import java.util.Calendar;
/* greenDao là một thư viện làm việc với sqlite, tạo ra các entity và dao, các entity sẽ mapping đến bảng tương ứng trong
 sqlite, trong */

public class MainActivity extends AppCompatActivity implements AllClick, FragmentManager.OnBackStackChangedListener {
    private HomeFragment fragmentHome;
    private LikeFragment fragmentLike;
    private NoteFragment fragmentNote;
    private FragmentManager fragmentManager;
    private BottomNavigationView btNavViewMain;
    private AdView avBanner;
    private InterstitialAd fullInterstitialAd;
    private AdRequest adRequest;
    private int countFull = 0;
    private LinearLayout addAdv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JoinDatabase.joinToOpenDB(getApplicationContext());
        pushNotification();
        findIDs();
        setValuesMain();
        //dang ki broadcast receiverInternet
        this.registerReceiver(this.receiverInternet, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        setValuesbtNavViewMain();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(this.receiverInternet);
        JoinDatabase.closeDBQuote();
    }

    public void pushNotification() {
        makeRandomSentence();
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent notificationIntent = new Intent("alarm_job");
        PendingIntent broadcast = PendingIntent.getBroadcast(getBaseContext(),0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,18);
        cal.set(Calendar.MINUTE, 43);
        cal.set(Calendar.SECOND, 50);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 1000*60*60*60, broadcast);

    }
    public void makeRandomSentence() {
        JoinDatabase.joinToOpenDB(getApplicationContext());
        QuotesNotifications.sentence = QuotesNotifications.randomSentence();

    }

    public void findIDs() {
        addAdv = (LinearLayout) findViewById(R.id.addAdv);
        fragmentManager = getFragmentManager();
        btNavViewMain = (BottomNavigationView) findViewById(R.id.btNavViewMain);
        fragmentManager.addOnBackStackChangedListener(this);
    }
    @Override
    public void setAvBanner() {
        avBanner = new AdView(getApplicationContext());
        avBanner.setAdSize(AdSize.SMART_BANNER);
        avBanner.setAdUnitId(getApplication().getString(R.string.id_banner));
        addAdv.addView(avBanner, 2);
    }

    public boolean isOnline() {
        ConnectivityManager connect = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return connect.getActiveNetworkInfo() != null && connect.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    @Override
    public void loadBannerWhenOffInternet() {
        if (addAdv.indexOfChild(avBanner) == 2) {
                    loadBanner();
        } else {
        }
    }
    @Override
    public void loadBanner() {
        adRequest = new AdRequest.Builder().build();
        avBanner.loadAd(adRequest);
    }

    @Override
    public void setAdsFull() {
        adRequest = new AdRequest.Builder().build();
        fullInterstitialAd = new InterstitialAd(getApplicationContext());
        fullInterstitialAd.setAdUnitId("ca-app-pub-2070890409282383/3768681955");
        fullInterstitialAd.loadAd(adRequest);
        fullInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                fullInterstitialAd.show();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }
        });
    }

    public void setValuesMain() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragmentHome = new HomeFragment();
        transaction.replace(R.id.LinearForFragment, fragmentHome);
        transaction.commit();
    }

    public void setValuesbtNavViewMain() {
        btNavViewMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                loadBannerWhenOffInternet();
                switch (item.getItemId()) {
                    case R.id.icHome:
                        if (fragmentHome.isVisible()) {
                            fragmentHome.listViewOne.smoothScrollToPosition(0);
                        } else {
                            deleteFragment();
                            fragmentHome = new HomeFragment();
                            transaction.replace(R.id.LinearForFragment, fragmentHome);
                            transaction.addToBackStack("Home");
                        }
                        break;
                    case R.id.icLike:
                        deleteFragment();
                        fragmentLike = new LikeFragment();
                        transaction.replace(R.id.LinearForFragment, fragmentLike);
                        transaction.addToBackStack("Like");
                        break;
                    case R.id.icNote:
                        deleteFragment();
                        fragmentNote = new NoteFragment();
                        transaction.replace(R.id.LinearForFragment, fragmentNote);
                        transaction.addToBackStack("Note");
                        break;
                }
                transaction.commit();
                return true;
            }
        });
    }
    public void setCheckedItem(boolean b1, boolean b2, boolean b3) {
        btNavViewMain.getMenu().findItem(R.id.icHome).setChecked(b1);
        btNavViewMain.getMenu().findItem(R.id.icLike).setChecked(b2);
        btNavViewMain.getMenu().findItem(R.id.icNote).setChecked(b3);
    }

    @Override
    public void onBackStackChanged() {
        //loadBanner();
        int length = fragmentManager.getBackStackEntryCount();
        if (length > 0) {
            FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(length - 1);
            if (entry.getName().equals("Note")) {
                setCheckedItem(false, false, true);
            } else if (entry.getName().equals("Like")) {
                setCheckedItem(false, true, false);
            } else if (entry.getName().equals("Home")) {
                setCheckedItem(true, false, false);
            } else if (entry.getName().equals("Topic")) {
                setCheckedItem(false, false, false);
            }
        } else if (length == 0) {
            setCheckedItem(true, false, false);
        }
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void deleteFragment() {
        if (fragmentManager.getBackStackEntryCount() >= 0) {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    @Override
    public void clickToMore(QuotesObject quote){
        countClick();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MoreValueFragment moreValueFragment = new MoreValueFragment();

        Bundle bundleItem = new Bundle();
        bundleItem.putSerializable("Quote", quote);
        moreValueFragment.setArguments(bundleItem);

        fragmentTransaction.replace(R.id.LinearForFragment, moreValueFragment);
        fragmentTransaction.addToBackStack("More");
        fragmentTransaction.commit();
    }
    @Override
    public void countClick() {
        if (countFull == 0) {
            countFull++;
            setAdsFull();
        } else if (countFull < 2) {
            countFull++;
        } else if (countFull == 2) {
            countFull = 0;
        }
    }

    private BroadcastReceiver receiverInternet = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            @SuppressWarnings("deprecation") NetworkInfo currentNetworkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (currentNetworkInfo.isConnectedOrConnecting() || currentNetworkInfo.isRoaming()) {
                setAvBanner();
                loadBanner();
            } else {
                if (addAdv.indexOfChild(avBanner) == 2) {
                    addAdv.removeViewAt(2);
                } else {

                }
            }
        }

    };

}
