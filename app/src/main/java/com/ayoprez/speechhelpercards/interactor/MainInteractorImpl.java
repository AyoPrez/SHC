package com.ayoprez.speechhelpercards.interactor;

import android.text.TextUtils;
import android.util.Log;

import com.ayoprez.speechhelpercards.R;
import com.ayoprez.speechhelpercards.ui.presenter.OnInfoCompletedListener;

import javax.inject.Inject;

/**
 * Created by ayo on 14.05.16.
 */
public class MainInteractorImpl implements MainInteractor {
    private static final String TAG = MainInteractorImpl.class.getName();

    @Inject
    public MainInteractorImpl() {
    }

    @Override
    public void getInformation(final String userName, final String cityName, final OnInfoCompletedListener listener) {

    }

}
