package com.ayoprez.speechhelpercards.presenterTests;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.presenter.ViewNotFoundException;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemPresenter;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemPresenterImpl;
import com.ayoprez.speechhelpercards.ui.recyclerview.main_recyclerview.ItemView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ayo on 09.07.16.
 */
public class AdapterPresenterTests {

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
    public void shouldBeAbleToLoadTheDeckFromTheRepositoryWhenValidDeckIsPresent(){
        when(mockView.getItemPosition()).thenReturn(1);

        presenter.setView(mockView, anyInt());

        verify(mockRepository, times(1)).getDeck(anyInt());

        verify(mockView, times(1)).getItemPosition();
        verify(mockView, times(1)).displayDeckNumberOfCards("7");
        verify(mockView, times(1)).displayDeckName("Worddy");
        verify(mockView, times(1)).displayDeckImage(123445);
        verify(mockView, never()).showError();
    }

    @Test
    public void shouldShowErrorMessageOnViewWhenDeckIsNotPresenter(){
        when(mockView.getItemPosition()).thenReturn(1);

        when(mockRepository.getDeck(anyInt())).thenReturn(null);

        presenter.setView(mockView, anyInt());

        verify(mockRepository, times(1)).getDeck(anyInt());

        verify(mockView, times(1)).getItemPosition();
        verify(mockView, never()).displayDeckNumberOfCards("7");
        verify(mockView, never()).displayDeckName("Worddy");
        verify(mockView, never()).displayDeckImage(123445);
        verify(mockView, times(1)).showError();
    }

    @Test
    public void shouldLoadDeckDetailsWhenTheViewIsSet(){
        presenter.setView(mockView, anyInt());

        verify(mockRepository, times(1)).getDeck(anyInt());
        verify(mockView, times(1)).displayDeckName(anyString());
        verify(mockView, times(1)).displayDeckImage(anyInt());
        verify(mockView, times(1)).displayDeckNumberOfCards(anyString());
    }

    @Test(expected = ViewNotFoundException.class)
    public void shouldThrowViewNotFoundExceptionWhenViewIsNull(){
        presenter.setView(null, 0);

        presenter.loadDeck(deck);
    }
}
