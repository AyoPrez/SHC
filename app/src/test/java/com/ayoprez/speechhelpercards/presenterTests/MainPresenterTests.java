package com.ayoprez.speechhelpercards.presenterTests;

import com.ayoprez.speechhelpercards.model.Deck;
import com.ayoprez.speechhelpercards.repository.MainRepository;
import com.ayoprez.speechhelpercards.ui.activity.MainView;
import com.ayoprez.speechhelpercards.ui.presenter.MainPresenter;
import com.ayoprez.speechhelpercards.ui.presenter.MainPresenterImpl;
import com.ayoprez.speechhelpercards.ui.presenter.ViewNotFoundException;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by ayo on 02.07.16.
 */
public class MainPresenterTests {

    MainRepository mockRepository;
    MainView mockView;
    MainPresenter presenter;
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

        mockView = mock(MainView.class);

        presenter = new MainPresenterImpl(mockRepository);
    }

    @Test
    public void shouldLoadDeckDetailsWhenTheViewIsSet(){
        presenter.setView(mockView);

        verify(mockRepository, never()).getDeck(anyInt());
    }

 }
