package com.ayoprez.speechhelpercards.repository;

import com.ayoprez.speechhelpercards.R;
import com.ayoprez.speechhelpercards.model.Cards;
import com.ayoprez.speechhelpercards.model.Deck;

import java.util.ArrayList;

/**
 * Created by ayo on 02.07.16.
 */
public class InMemoryRepository implements MainRepository {
    private static final String TAG = InMemoryRepository.class.getSimpleName();

    private Deck deck;

    @Override
    public Deck getDeck(int id) {
        if(deck == null){
            deck = new Deck();
            deck.setId(id);
            deck.setName("Words");
            deck.setNumberOfCards("6");
            deck.setImage(R.id.imageView_madeInGermany);
        }
        return deck;
    }

    @Override
    public void saveDeck(Deck deck) {
        if(this.deck == null){
            this.deck = getDeck(0);
        }

        this.deck.setId(deck.getId());
        this.deck.setImage(deck.getImage());
        this.deck.setName(deck.getName());
        this.deck.setNumberOfCards(deck.getNumberOfCards());
    }

    @Override
    public ArrayList<Deck> getAllDecks() {
        ArrayList<Deck> decks = new ArrayList<>();
        decks.add(deck);
        decks.add(deck);
        decks.add(deck);
        return decks;
    }

    @Override
    public void deleteDeck(int id) {
        deck = null;
    }

    @Override
    public int getCardId() {
        return 1;
    }

    @Override
    public ArrayList<String> getAllDeckCardsText(int deckId) {
        return null;
    }
}
