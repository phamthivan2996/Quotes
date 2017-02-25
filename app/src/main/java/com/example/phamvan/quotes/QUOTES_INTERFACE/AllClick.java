package com.example.phamvan.quotes.QUOTES_INTERFACE;


import com.example.phamvan.quotes.QUOTES_OBJECTS.QuotesObject;

/**
 * Created by PhamVan on 2/3/2017.
 */
public interface AllClick {
    void loadBanner();
    void countClick();
    void clickToMore(QuotesObject quotes);
    void setAdsFull();
    void deleteFragment();
    void setAvBanner();
    void loadBannerWhenOffInternet();
}
