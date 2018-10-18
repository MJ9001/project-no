package edu.vcu.nopreference.Screens;

import org.junit.Test;
import org.mockito.Mockito;

import edu.vcu.nopreference.Objects.base.objectMenu;


import static org.junit.Assert.*;

public class objectMainMenuTest {
    @Test
    public void testMainMenu(){ //tests to see if main menu is being shown currently
        mainMenu mockMenu = Mockito.mock(mainMenu.class);
        assertFalse(mockMenu.isShown());
    }

    @Test
    public void testMainMenuStart(){//tests to see if when the start button is clicked on the main menu then the menu is hidden and the game is displayed
        mainMenu mockMenu = Mockito.mock(mainMenu.class);
        mockMenu.fakePress();
        assertFalse(mockMenu.isShown());
    }

    @Test
    public void testQuitToMenu(){//tests to see if main menu is being shown currently
        inGame.paused = true;
        objectMenu.fakePress();
        assertTrue(objectMenu.fakePress());
    }
}