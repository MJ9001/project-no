package edu.vcu.nopreference.Screens;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//import edu.vcu.nopreference.Objects.base.GameTest;
import edu.vcu.nopreference.Untitled;

import static org.junit.Assert.*;

public class objectMainMenuTest /*extends GameTest*/ {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMainMenu(){
        mainMenu mockMenu = Mockito.mock(mainMenu.class);
        assertFalse(mockMenu.isShown());
    }
    @Test
    public void testMainMenuStart(){
        mainMenu mockMenu = Mockito.mock(mainMenu.class);
        mockMenu.fakePress();
        assertFalse(mockMenu.isShown());
    }
    @Test
    public void testQuitToMenu(){
        mainMenu mockMenu = Mockito.mock(mainMenu.class);
        mockMenu.fakePress();
        assertFalse(mockMenu.isShown());
    }
    @org.junit.After
    public void tearDown() throws Exception {
    }
}