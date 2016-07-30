package com.ayoprez.speechhelpercards.repository;

import com.ayoprez.speechhelpercards.model.Cards;
import com.ayoprez.speechhelpercards.model.Deck;

import org.greenrobot.greendao.annotation.ToMany;

import java.util.ArrayList;

/**
 * Created by ayo on 16.07.16.
 */
public class MainRepositoryImpl implements MainRepository {


    @Override
    public Deck getDeck(int id) {
       return null;
    }

    @Override
    public void saveDeck(final Deck deck) {

    }

    private ArrayList<Cards> saveCards(final ArrayList<Cards> cards){
        return cards;
    }


    @Override
    public ArrayList<Deck> getAllDecks() {
        return null;
    }

    @Override
    public void deleteDeck(int id) {
        final ArrayList<Deck> deck1 = null;
    }

    @Override
    public ArrayList<String> getAllDeckCards(int deckId) {
        Deck deck = getDeck(deckId);

        ArrayList<String> textsList = new ArrayList<>();

        for(Cards card : deck.getCards()){
            textsList.add(card.getText());
        }

        return textsList;
    }
}
