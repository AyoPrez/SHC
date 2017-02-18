package com.ayoprez.speechhelpercards.ui.recyclerview.add_deck_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.ayoprez.speechhelpercards.R;
import com.ayoprez.speechhelpercards.dependency_inyection.SHCApplication;
import com.ayoprez.speechhelpercards.model.Cards;
import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.ui.activity.AddDeckActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by ayo on 16.07.16.
 */
public class AddDeckAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = AddDeckAdapter.class.getSimpleName();

    protected Context context;
    protected int itemCounts = 2;

    private List<String> textList = new ArrayList<>();

    private final int TEXT = 1, IMAGE = 0;

    @Inject
    AddDeckItemPresenter presenter;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        initAdapterComponents();
        View viewText = LayoutInflater.from(context).inflate(R.layout.item_add_deck, parent, false);
        View viewPlaceholder = LayoutInflater.from(context).inflate(R.layout.placeholder_add_deck, parent, false);

        if(viewType == TEXT){
            return new AddDeckViewHolder(viewText);
        }else {
            return new AddDeckImageViewHolder(viewPlaceholder);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == getItemCount() - 1 ? IMAGE:TEXT;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType()){
            case TEXT:
                presenter.setView((AddDeckItemView) holder);
                holder.itemView.findViewById(R.id.et_addDeck);

                //TODO get somehow the text in all the edittexts of the recyclerview. It wouldn't be here. It would be after click button save

                break;
            case IMAGE:
                presenter.loadPlaceHolder((AddDeckImageView) holder);

                final LinearLayout placeholder = ((AddDeckImageViewHolder) holder).llPlaceholder;
                if (placeholder != null) {
                    placeholder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            itemCounts++;
                            notifyItemInserted(position+1);
                            //Add a way to jump to the new position after add it
                        }
                    });
                }
                break;
        }
    }

    public Deck getDeck(){
        Deck deck = new Deck();
        Cards cards;
        RealmList<Cards> cardsList = new RealmList<>();

        for(int i = 0; i < itemCounts - 1; i++){
            if(getItemViewType(i) == TEXT) {
                cards = new Cards();
                cards.setText(textList.get(i));
                cardsList.add(cards);
            }
        }

        deck.setImage(R.drawable.cards_icon);
        deck.setNumberOfCards(String.valueOf(cardsList.size()));
        deck.setName(cardsList.get(0).getText()); //Add a field to introduce the name and the image
        deck.setCards(cardsList);

        return deck;
    }

    @Override
    public int getItemCount() {
        return itemCounts;
    }

    public void initAdapterComponents(){
        ((SHCApplication) context.getApplicationContext()).getAppComponent().inject(this);
    }

}
