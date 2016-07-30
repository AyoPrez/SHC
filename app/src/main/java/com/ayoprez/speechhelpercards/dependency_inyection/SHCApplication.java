package com.ayoprez.speechhelpercards.dependency_inyection;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * Created by ayo on 14.05.16.
 */
public class SHCApplication extends Application {


    public static final boolean ENCRYPTED = true;
    private AppComponent appComponent;
//    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponents();
//        initGreenDao();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void initAppComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

//    public void initGreenDao() {
//        DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
//        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
//        daoSession = new DaoMaster(db).newSession();
//    }
//
//    public DaoSession getDaoSession() {
//        return daoSession;
//    }
}
