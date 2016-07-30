package com.ayoprez.speechhelpercards.presenterTests;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemPresenter;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemPresenterImpl;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ayo on 30.07.16.
 */
public class AddDeckItemPresenterTest {

    MainRepository mockRepository;
    ItemView mockView;
    ItemPresenter presenter;
    Deck deck;

    @Before
    public void setup(){
        mockRepository = mock(MainRepository.class);
        deck = new Deck();
        deck.setId(1);
        deck.setName("Worddy");
        deck.setImage(123445);
        deck.setNumberOfCards("7");
        when(mockRepository.getDeck(anyInt())).thenReturn(deck);

        mockView = mock(ItemView.class);

        presenter = new ItemPresenterImpl(mockRepository);
    }

    @Test
    public void shouldGetTextByPosition(){

    }

    @Test
    public void shouldLoadPlaceHolder(){

    }

    @Test
    public void shouldReturnTotalNumberOfCards(){

    }

}
