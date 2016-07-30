package com.ayoprez.speechhelpercards.dependency_inyection;

import com.ayoprez.speechhelpercards.ui.activity.AddDeckActivity;
import com.ayoprez.speechhelpercards.ui.activity.HelperCardsActivity;
import com.ayoprez.speechhelpercards.ui.activity.MainActivity;
import com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview.AddDeckAdapter;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.MainRecyclerViewAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ayo on 14.05.16.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(SHCApplication application);
    void inject(MainActivity activity);
    void inject(MainRecyclerViewAdapter adapter);
    void inject(AddDeckActivity activity);
    void inject(AddDeckAdapter adapter);
    void inject(HelperCardsActivity activity);
}
