package com.ayoprez.speechhelpercards.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ayoprez.speechhelpercards.R;
import com.ayoprez.speechhelpercards.dependency_inyection.SHCApplication;
import com.ayoprez.speechhelpercards.model.Cards;
import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.ui.presenter.MainPresenter;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.MainRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMainActivityComponents();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFloatingButton();
    }

    private Cards setCards(int id, String text){
        Cards cards = new Cards();
        cards.setText(text);
        cards.setId(id);
        return cards;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.setView(this);
        mainPresenter.initDeskRecyclerView();
    }

    public void initMainActivityComponents(){
        ((SHCApplication)getApplication()).getAppComponent().inject(this);
    }

    @Override
    public void initFloatingButton(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(AddDeckActivity.class);
            }
        });
    }

    @Override
    public void loadDeskRecyclerView(List<Deck> decksList) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new MainRecyclerViewAdapter(decksList));
    }

    @Override
    public void showError() {
        Log.e(TAG, "Error...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
//            changeActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
