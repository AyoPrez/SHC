package com.ayoprez.speechhelpercards.ui.presenter;

import com.ayoprez.speechhelpercards.interactor.MainInteractor;
import com.ayoprez.speechhelpercards.ui.activity.MainView;

import javax.inject.Inject;

/**
 * Created by ayo on 14.05.16.
 */
public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private MainInteractor mainInteractor;

    @Inject
    public MainPresenterImpl(MainView mainView, MainInteractor mainInteractor) {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }
    @Override
    public void requestInformation() {

    }

}
