package com.example.phamvan.quotes.QUOTES_DB;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MAN_WOMAN".
*/
public class ManWomanDao extends AbstractDao<ManWoman, Long> {

    public static final String TABLENAME = "MAN_WOMAN";

    /**
     * Properties of entity ManWoman.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "ID");
        public final static Property Author = new Property(1, String.class, "author", false, "AUTHOR");
        public final static Property Sentence = new Property(2, String.class, "sentence", false, "SENTENCE");
        public final static Property Vietnamese = new Property(3, String.class, "vietnamese", false, "VIETNAMESE");
    }


    public ManWomanDao(DaoConfig config) {
        super(config);
    }
    
    public ManWomanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MAN_WOMAN\" (" + //
                "\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"AUTHOR\" TEXT," + // 1: author
                "\"SENTENCE\" TEXT," + // 2: sentence
                "\"VIETNAMESE\" TEXT);"); // 3: vietnamese
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MAN_WOMAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ManWoman entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(2, author);
        }
 
        String sentence = entity.getSentence();
        if (sentence != null) {
            stmt.bindString(3, sentence);
        }
 
        String vietnamese = entity.getVietnamese();
        if (vietnamese != null) {
            stmt.bindString(4, vietnamese);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ManWoman entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(2, author);
        }
 
        String sentence = entity.getSentence();
        if (sentence != null) {
            stmt.bindString(3, sentence);
        }
 
        String vietnamese = entity.getVietnamese();
        if (vietnamese != null) {
            stmt.bindString(4, vietnamese);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ManWoman readEntity(Cursor cursor, int offset) {
        ManWoman entity = new ManWoman( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // author
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // sentence
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // vietnamese
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ManWoman entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAuthor(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSentence(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setVietnamese(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ManWoman entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ManWoman entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ManWoman entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}