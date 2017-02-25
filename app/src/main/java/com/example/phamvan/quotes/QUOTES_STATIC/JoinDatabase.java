package com.example.phamvan.quotes.QUOTES_STATIC;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.phamvan.quotes.QUOTES_DATABASE.QuotesDB;
import com.example.phamvan.quotes.QUOTES_DB.DaoMaster;
import com.example.phamvan.quotes.QUOTES_DB.DaoSession;

/**
 * Created by PhamVan on 2/21/2017.
 */
public class JoinDatabase {
    public static QuotesDB quotesDB;
    public static SQLiteDatabase db;
    public static DaoMaster daoMaster ;
    public static DaoSession daoSession ;

    public static void joinToOpenDB(Context context) {
         quotesDB = new QuotesDB(context);
         db = quotesDB.getSQLiteDatabase();
         daoMaster = new DaoMaster(db);
         daoSession = daoMaster.newSession();
    }
    public static void closeDBQuote(){
        quotesDB.closeDataBase();
        db.close();
        daoSession.clear();
    }

}
