package com.ayoprez.speechhelpercards.repository;

import com.ayoprez.speechhelpercards.model.Cards;
import com.ayoprez.speechhelpercards.model.Deck;

import java.util.ArrayList;

/**
 * Created by ayo on 02.07.16.
 */
public interface MainRepository {
    //In the future created by greenDao
    Deck getDeck(int id);
    void saveDeck(Deck deck);
    ArrayList<Deck> getAllDecks();
    void deleteDeck(int id);

    ArrayList<String> getAllDeckCards(int deckId);
}
