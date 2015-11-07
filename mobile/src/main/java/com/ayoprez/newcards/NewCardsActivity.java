package com.ayoprez.newcards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ayoprez.speechhelpcards.R;
import com.ayoprez.speechhelpcards.SpacesItemDecoration;

import java.util.ArrayList;

/**
 * Created by AyoPrez on 8/08/15.
 */
public class NewCardsActivity extends AppCompatActivity{

    private NewCardsRecyclerViewAdapter newCardsRecyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcards);

        initToolbar();
        initRecyclerView();
        buttonAddNewCard();
        buttonSaveNewCard();
    }

    public void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.newcards_title);
    }

    public void initRecyclerView(){
        newCardsRecyclerViewAdapter = new NewCardsRecyclerViewAdapter(fillArray());
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_newcards);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.space_between_columns);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newCardsRecyclerViewAdapter);
    }

    public ArrayList<String> fillArray(){
        ArrayList<String> defaultText = new ArrayList<>();
        defaultText.add(getString(R.string.newcards_default_text));
        return defaultText;
    }

    public void buttonAddNewCard(){
        Button button = (Button) findViewById(R.id.button_addNewCard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewCard();
            }
        });
    }

    public void buttonSaveNewCard(){
        Button button = (Button) findViewById(R.id.button_saveNewCard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewCard();
            }
        });

    }

    private void saveNewCard(){
        ArrayList<NewCards> newCardsArrayList = new ArrayList<>();
        //I use NewCards object, but there is GroupCard and Card objects in java-gen that I should use
        newCardsArrayList.add(new NewCards(1, 1, 4, "Hola", 1, "Bienvenida"));
        newCardsArrayList.add(new NewCards(2, 1, 4, "Hello", 2, "Bienvenida"));
        newCardsArrayList.add(new NewCards(3, 1, 4, "Hallo", 3, "Bienvenida"));
        newCardsArrayList.add(new NewCards(4, 1, 4, "Ciao", 4, "Bienvenida"));

//Tengo que terminar y probar esto. A ver si guarda este ejemplo en la base de datos y sigo desarrollando
        //esa parte de la aplicación Cuando eso funcione bien con este ejemplo me buscaré la vida para
        //coger el texto de cada tarjeta

    }

    private void setCardsInDatabase(){

    }

    private void addNewCard(){
        newCardsRecyclerViewAdapter.setItemCount();
    }
}