package com.ayoprez.speechhelpercards.ui.activity;

import com.ayoprez.speechhelpercards.dependency_inyection.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by ayo on 14.05.16.
 */
@ActivityScope
@Subcomponent(
        modules = {MainActivityModule.class}
)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}