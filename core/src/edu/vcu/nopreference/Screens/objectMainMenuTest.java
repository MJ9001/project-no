package edu.vcu.nopreference.Screens;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//import edu.vcu.nopreference.Objects.base.GameTest;
import edu.vcu.nopreference.Objects.base.objectMenu;
import edu.vcu.nopreference.Objects.base.objectPause;
import edu.vcu.nopreference.Untitled;

import static org.junit.Assert.*;

public class objectMainMenuTest /*extends GameTest*/ {

    @org.junit.Before
    public void setUp() throws Exception {

    }

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
        objectMenu.fakeOnPress();
        assertTrue(objectMenu.returnToMain());
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
}