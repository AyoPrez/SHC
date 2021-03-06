package com.ayoprez.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import SHC_Schema.DaoMaster;
import SHC_Schema.DaoSession;


/**
 * Created by Ayoze on 29/01/15.
 */
public class CreateDatabase{

    public DaoSession daoSession;

    public CreateDatabase(Context context){
        setupDatabase(context);
    }

    private void setupDatabase(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "SHC_Schema", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}