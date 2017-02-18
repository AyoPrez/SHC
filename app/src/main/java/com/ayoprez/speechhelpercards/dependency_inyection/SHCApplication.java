package com.ayoprez.speechhelpercards.dependency_inyection;

import android.app.Application;

import com.ayoprez.speechhelpercards.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ayo on 14.05.16.
 */
public class SHCApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponents();
        initRealm();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void initAppComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public void initRealm(){
        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("shc")
                .schemaVersion(R.string.app_version)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
