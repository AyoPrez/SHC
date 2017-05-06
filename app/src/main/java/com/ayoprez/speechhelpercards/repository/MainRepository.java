package com.ayoprez.speechhelpercards.repository;

import com.ayoprez.speechhelpercards.model.Deck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayo on 02.07.16.
 */
public interface MainRepository {

    Deck getDeck(int id);
    void saveDeck(Deck deck);
    List<Deck> getAllDecks();
    void deleteDeck(int id);
    int getCardId();

    List<String> getAllDeckCardsText(int deckId);
}
