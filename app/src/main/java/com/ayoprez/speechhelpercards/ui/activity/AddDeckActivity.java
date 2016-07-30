package com.ayoprez.speechhelpercards.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ayoprez.speechhelpercards.R;
import com.ayoprez.speechhelpercards.dependency_inyection.SHCApplication;
import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.ui.presenter.AddDeckPresenter;
import com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview.AddDeckAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ayo on 16.07.16.
 */
public class AddDeckActivity extends BaseActivity implements AddDeckView {
    private static final String TAG = AddDeckActivity.class.getSimpleName();

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    protected AddDeckAdapter addDeckAdapter;

    @Inject
    AddDeckPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAddDeckActivityComponents();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        floatingActionButton.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.initRecyclerView();
    }

    public void initAddDeckActivityComponents(){
        ((SHCApplication)getApplication()).getAppComponent().inject(this);
    }

    @Override
    public void loadAddDeskRecyclerView() {
        addDeckAdapter = new AddDeckAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(addDeckAdapter);
    }

    @Override
    public void showDeckSavedMessage() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_deck_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                changeActivity(MainActivity.class);
                return true;
            case R.id.save_deck:
                presenter.saveDeck(addDeckAdapter.getDeck());
                return true;
        }
        return true;
    }

}
