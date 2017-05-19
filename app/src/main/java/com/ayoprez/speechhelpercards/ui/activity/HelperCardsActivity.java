package com.ayoprez.speechhelpercards.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

    @OnClick(R.id.backToLastCardButton)
    void pressBAckToLastCardButton(){
        helperCardsPresenter.goBackToLastCard();
    }

    @Inject
    HelperCardsPresenter helperCardsPresenter;

    private TextView textView;
    private int textSize = 15;

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
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item, textsList);
        flingAdapterView.setAdapter(adapter);

        flingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                textsList.remove(0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
                fixTextSize();
            }

            @Override
            public void onScroll(float v) {
            }
        });
    }

    private void fixTextSize(){
        View view = flingAdapterView.getSelectedView();

        if(view != null) {
            textView = (TextView) view.findViewById(R.id.cardText);

            textView.setTextSize(textSize);
        }
    }

    @Override
    public void increaseTextSize() {
        textView = (TextView) flingAdapterView.getSelectedView().findViewById(R.id.cardText);

//        if (textSize >= 15 && textSize < 100) {
            textSize = textSize + 3;
            textView.setTextSize(textSize);
//        } else {
//            Toast.makeText(this, "Limit " +  textSize, Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    public void decreaseTextSize() {
        textView = (TextView) flingAdapterView.getSelectedView().findViewById(R.id.cardText);

//        if (textSize >= 12 && textSize < 100) {
            textSize = textSize - 3;
            textView.setTextSize(textSize);
//        } else {
//            Toast.makeText(this, "Limit " + textSize, Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    public void seeLastCard() {
        View view = flingAdapterView.getSelectedView();

        if(view != null){
            textView = (TextView) view.findViewById(R.id.cardText);

            textView.setText("Halaaaaaa");
        }

    }

}
