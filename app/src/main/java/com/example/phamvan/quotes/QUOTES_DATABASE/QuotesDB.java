package com.example.phamvan.quotes.QUOTES_DATABASE;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.phamvan.quotes.QUOTES_DB.DaoMaster;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by PhamVan on 1/25/2017.
 */
public class QuotesDB extends DaoMaster.OpenHelper {
    private Context context;
    private SQLiteDatabase myDb;
    private static String DB_PATH = "/data/data/com.example.phamvan.quotes/databases/";
    private static String DB_NAME = "QUOTATION.sqlite";

    public QuotesDB(Context context) {
        super(context, DB_NAME, null);
        this.context = context;
        try {
            createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            openDataBase();
        }catch(SQLException sqle){
            throw sqle;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {// hàm oncreate sẽ được thực hiện luôn, khi được gọi đến activity này,
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public synchronized void close() {
        if(myDb!=null && myDb.isOpen()) {
            myDb.close();
        }
        super.close();
    }
    public SQLiteDatabase getSQLiteDatabase() {
        return myDb;
    }
    public void copyDataBase() throws IOException {
        InputStream myInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void createDataBase() throws IOException{
        SQLiteDatabase sqliteDatabase=null;
        if(checkDataBase()){

        }else{
            sqliteDatabase= this.getReadableDatabase();
            sqliteDatabase.close();
            copyDataBase();
        }

    }
    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            checkDB = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);

        }catch(SQLiteException e){
        }
        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }
    public void openDataBase() throws SQLException {

        myDb = SQLiteDatabase.openDatabase(DB_PATH+DB_NAME,null,SQLiteDatabase.OPEN_READWRITE);

    }
    public void closeDataBase() throws SQLException {
        myDb.close();
    }
}
