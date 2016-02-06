package com.ayoprez.speechhelpcards;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by AyoPrez on 3/08/15.
 */
public class CardsActivity extends AppCompatActivity {

    @InjectView(R.id.backToLastCard) ImageButton imageButton;

    private ArrayList<String> cardsText;
    private ArrayAdapter<String> arrayAdapter;
    private TextView text;
    private ArrayList<String> removedCards;

    @InjectView(R.id.frame)
    SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        ButterKnife.inject(this);

        Texts text = new Texts();

        cardsText = new ArrayList<>();
        removedCards = new ArrayList<>();
        cardsText.add(text.dozenText);
        cardsText.add(text.androidPayText);
        cardsText.add(text.fingerprintText);
        cardsText.add(text.permissionsText);
        cardsText.add(text.shareDirectText);
        cardsText.add(text.bluetoothDetection);
        cardsText.add(text.bleLocation);

        if(savedInstanceState != null){
            for(int i = 0; i < savedInstanceState.getInt("nItem"); i++){
                cardsText.remove(0);
            }
        }

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.cardText, cardsText);

        changeRevertButtonVisibility();

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                cardsText.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                removedCards.add(dataObject.toString());
                changeRevertButtonVisibility();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                removedCards.add(dataObject.toString());
                changeRevertButtonVisibility();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                cardsText.add("End of the presentation");
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("nItem", removedCards.size());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for(int i = 0; i < savedInstanceState.getInt("nItem"); i++){
            cardsText.remove(0);
        }
    }

    public void changeRevertButtonVisibility(){
        if(removedCards.isEmpty()) {
            imageButton.setVisibility(View.GONE);
        }else{
            imageButton.setVisibility(View.VISIBLE);
        }
    }


    @OnClick(R.id.more)
    public void more() {
        text = (TextView) flingContainer.getSelectedView().findViewById(R.id.cardText);
        int size = (int) text.getTextSize();
        if (size < 100) {
            text.setTextSize((size + 2) - (size / 2));
        } else {
            Toast.makeText(this, "Limit", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.less)
    public void less() {
        text = (TextView) flingContainer.getSelectedView().findViewById(R.id.cardText);
        int size = (int) text.getTextSize();
        if (size > 25) {
            text.setTextSize((size - 2) - (size / 2));
        } else {
            Toast.makeText(this, "Limit", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.backToLastCard)
    public void getLastCard(){
        text = (TextView) flingContainer.getSelectedView().findViewById(R.id.cardText);
        text.setText(removedCards.get(removedCards.size() - 1));
        Log.e("Cards", flingContainer.getAdapter().getItem(removedCards.size() - 1).toString());
        removedCards.remove(removedCards.size() - 1);
        changeRevertButtonVisibility();

    }
}