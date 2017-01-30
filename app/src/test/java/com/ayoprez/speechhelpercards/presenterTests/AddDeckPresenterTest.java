package com.ayoprez.speechhelpercards.presenterTests;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.activity.AddDeckView;
import com.ayoprez.speechhelpercards.ui.presenter.AddDeckPresenter;
import com.ayoprez.speechhelpercards.ui.presenter.AddDeckPresenterImpl;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemPresenter;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemPresenterImpl;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ayo on 30.07.16.
 */
public class AddDeckPresenterTest {

    MainRepository mockRepository;
    AddDeckView mockView;
    AddDeckPresenter presenter;
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

        mockView = mock(AddDeckView.class);

        presenter = new AddDeckPresenterImpl(mockRepository);
    }

    @Test
    public void shouldInitRecyclerView(){
        presenter.setView(mockView);
        presenter.initRecyclerView();

        verify(mockView, times(1)).loadAddDeckRecyclerView();
    }

    @Test
    public void shouldAddMoreEditTextsAfterPressButton(){

    }

    @Test
    public void shouldBeAbleToSaveDeck(){

    }

    @Test
    public void shouldShowMessageAfterSaveDeck(){

    }
}
