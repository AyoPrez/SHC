package com.ayoprez.speechhelpercards.dependency_inyection;

import android.app.Application;

import com.ayoprez.speechhelpercards.ui.activity.MainActivityComponent;
import com.ayoprez.speechhelpercards.ui.activity.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ayo on 14.05.16.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainActivityComponent plus(MainActivityModule module);
    Application application();
}
