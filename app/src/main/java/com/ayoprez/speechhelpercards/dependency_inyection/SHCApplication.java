package com.ayoprez.speechhelpercards.dependency_inyection;

import android.app.Application;
import android.content.Context;

/**
 * Created by ayo on 14.05.16.
 */
public class SHCApplication extends Application {
    private static final String TAG = SHCApplication.class.getSimpleName();

    private static AppComponent appComponent;
    private static SHCApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initAppComponents();
    }

    public static SHCApplication get(Context context) {
        return (SHCApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void initAppComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    /**
     * Visible only for testing purposes.
     */
    public void setTestComponent(AppComponent testingComponent) {
        appComponent = testingComponent;
    }
}
