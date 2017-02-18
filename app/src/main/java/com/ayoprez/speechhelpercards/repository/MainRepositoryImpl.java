package com.ayoprez.speechhelpercards.repository;

import com.ayoprez.speechhelpercards.model.Cards;
import com.ayoprez.speechhelpercards.model.Deck;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by ayo on 16.07.16.
 */
public class MainRepositoryImpl implements MainRepository {

    private Realm deckRealm;

    public MainRepositoryImpl(){
        deckRealm = Realm.getDefaultInstance();
    }

    @Override
    public Deck getDeck(int id) {
       return deckRealm.where(Deck.class).equalTo("id", id).findFirst();
    }

    @Override
    public void saveDeck(final Deck deck) {
        Realm realmDeck = Realm.getDefaultInstance();

        realmDeck.beginTransaction();

        int id;

        if(realmDeck.where(Deck.class).max("id") == null){
            id = 1;
        }else{
            id =  (int) ((long)(realmDeck.where(Deck.class).max("id")) + 1);
        }

        deck.setId(id);

        realmDeck.copyToRealmOrUpdate(deck);
        realmDeck.commitTransaction();

        List<Deck> deeck = realmDeck.where(Deck.class).equalTo("id", id).findAll();

        realmDeck.close();


    }

    private void saveCards(final ArrayList<Cards> cards){
        Deck saveDeck = new Deck();
        saveDeck.setCards(cards);
        saveDeck(saveDeck);
    }

    @Override
    public List<Deck> getAllDecks() {
        Realm realm = Realm.getDefaultInstance();

        ArrayList<Deck> listOfDecks = new ArrayList<>(realm.where(Deck.class).findAll());

        realm.close();

        return listOfDecks;
    }

    @Override
    public void deleteDeck(final int id) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Deck> result = realm.where(Deck.class).equalTo("id", id).findAll();
                RealmResults<Cards> cardsResult = realm.where(Cards.class).equalTo("cardsId", id).findAll();
                result.deleteAllFromRealm();
                cardsResult.deleteAllFromRealm();
            }
        });

        realm.close();
    }

    @Override
    public List<String> getAllDeckCardsText(int deckId) {
        Deck deck = getDeck(deckId);

        ArrayList<String> textsList = new ArrayList<>();

        for(Cards card : deck.getCards()){
            textsList.add(card.getText());
        }

        return textsList;
    }
}
