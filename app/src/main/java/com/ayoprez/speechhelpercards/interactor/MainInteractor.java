package com.ayoprez.speechhelpercards.interactor;

import com.ayoprez.speechhelpercards.ui.presenter.OnInfoCompletedListener;

/**
 * Created by ayo on 14.05.16.
 */
public interface MainInteractor {
    public void getInformation(String userName, String cityName, final OnInfoCompletedListener listener);
}
