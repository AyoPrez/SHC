package com.ayoprez.speechhelpercards.ui.activity;

import com.ayoprez.speechhelpercards.dependency_inyection.ActivityScope;
import com.ayoprez.speechhelpercards.interactor.MainInteractor;
import com.ayoprez.speechhelpercards.interactor.MainInteractorImpl;
import com.ayoprez.speechhelpercards.ui.presenter.MainPresenter;
import com.ayoprez.speechhelpercards.ui.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ayo on 14.05.16.
 */
@Module
public class MainActivityModule {
    private static final String TAG = MainActivityModule.class.getSimpleName();

    public final MainView view;

    public MainActivityModule(MainView view){
        this.view = view;
    }

    @Provides
    @ActivityScope
    MainView provideMainView() {
        return this.view;
    }

    @Provides
    @ActivityScope
    MainInteractor provideMainInteractor(MainInteractorImpl interactor){
        return interactor;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(MainPresenterImpl presenter) {
        return presenter;
    }
}
