package com.ayoprez.speechhelpercards.dependency_inyection;

import android.app.Application;
import android.content.Context;

import com.ayoprez.speechhelpercards.repository.InMemoryRepository;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.repository.MainRepositoryImpl;
import com.ayoprez.speechhelpercards.ui.activity.HelperCardsActivity;
import com.ayoprez.speechhelpercards.ui.presenter.AddDeckPresenter;
import com.ayoprez.speechhelpercards.ui.presenter.AddDeckPresenterImpl;
import com.ayoprez.speechhelpercards.ui.presenter.HelperCardsPresenter;
import com.ayoprez.speechhelpercards.ui.presenter.HelperCardsPresenterImpl;
import com.ayoprez.speechhelpercards.ui.presenter.MainPresenter;
import com.ayoprez.speechhelpercards.ui.presenter.MainPresenterImpl;
import com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview.AddDeckItemPresenter;
import com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview.AddDeckItemPresenterImpl;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemPresenter;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ayo on 14.05.16.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }

    @Provides
    @Singleton
    public MainRepository provideMainRepository(){
        return new MainRepositoryImpl();
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(MainRepository repository){
        return new MainPresenterImpl(repository);
    }

    @Provides
    @Singleton
    public ItemPresenter provideAdapterPresenter(MainRepository repository){
        return new ItemPresenterImpl(repository);
    }

    @Provides
    @Singleton
    public AddDeckPresenter provideAddDeskPresenter(MainRepository repository){
        return new AddDeckPresenterImpl(repository);
    }

    @Provides
    @Singleton
    public AddDeckItemPresenter provideAddDeckItemAdapterPresenter(MainRepository mainRepository){
        return new AddDeckItemPresenterImpl(mainRepository);
    }

    @Provides
    @Singleton
    public HelperCardsPresenter provideHelperCardsPresenter(MainRepository repository){
        return new HelperCardsPresenterImpl(repository);
    }
}
