package com.ayoprez.speechhelpercards.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import com.ayoprez.speechhelpercards.R;
import com.ayoprez.speechhelpercards.dependency_inyection.SHCApplication;
import com.ayoprez.speechhelpercards.ui.presenter.HelperCardsPresenter;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ayo on 16.07.16.
 */
public class HelperCardsActivity extends BaseActivity implements HelperCardsView {
    private static final String TAG = HelperCardsActivity.class.getSimpleName();

    private int deckId;

    @BindView(R.id.frame)
    SwipeFlingAdapterView flingAdapterView;

    @OnClick(R.id.moreButton)
    void pressMoreButton(){
        helperCardsPresenter.pushedMoreButton();
    }

    @OnClick(R.id.lessButton)
    void pressLessButton(){
        helperCardsPresenter.pushedLessButton();
    }

    @Inject
    HelperCardsPresenter helperCardsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMainActivityComponents();
        setContentView(R.layout.activity_cards);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            deckId = extras.getInt("id");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        helperCardsPresenter.setView(this);
        helperCardsPresenter.loadCardsTexts(deckId);
    }

    public void initMainActivityComponents(){
        ((SHCApplication)getApplication()).getAppComponent().inject(this);
    }

    @Override
    public void showText(final List<String> textsList) {
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, textsList);
        flingAdapterView.setAdapter(adapter);
        flingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                textsList.remove(0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o) {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });
    }

}
