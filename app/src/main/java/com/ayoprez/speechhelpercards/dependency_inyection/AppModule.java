package com.ayoprez.speechhelpercards.dependency_inyection;

import android.app.Application;
import android.content.res.Resources;

import javax.annotation.Resource;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ayo on 14.05.16.
 */
@Module
public class AppModule {
    private static final String TAG = AppModule.class.getSimpleName();

    SHCApplication app;

    public AppModule(SHCApplication application){
        app = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication(){
        return app;
    }

    @Provides
    @Singleton
    protected Resources provideResources(){
        return app.getResources();
    }

}
