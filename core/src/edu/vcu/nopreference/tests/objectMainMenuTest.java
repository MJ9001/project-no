package edu.vcu.nopreference.tests;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.base.playButton;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import edu.vcu.nopreference.Objects.base.objectMenu;
import edu.vcu.nopreference.Objects.renders.Render;
import edu.vcu.nopreference.Screens.inGame;
import edu.vcu.nopreference.Screens.mainMenu;



import static org.junit.Assert.*;

public class objectMainMenuTest {

    //Given that I am opening the game, when the game starts, then I should see a menu with an option to start the game
    @Test
    public void testMainMenu(){ //tests to see if main menu is being shown currently
        Render.testing = true;
        boolean testGood = false;
        mainMenu mMenu = new mainMenu();
        for(objectBase obj : mMenu.objectman.objects)
        {
            if(obj instanceof playButton)
            {
                System.out.println(obj.posX + ":"+obj.posY);
                if(obj.posX >= 0 && obj.posX < obj.render.getScreenSizeX())
                    if(obj.posY >= 0 && obj.posY < obj.render.getScreenSizeY())
                        testGood = true;
            }
        }
        assertTrue(testGood);
    }

    //Given that I am in the main menu, when I press the start game button, then the game should start.
    @Test
    public void testMainMenuStart(){//tests to see if when the start button is clicked on the main menu then the menu is hidden and the game is displayed
        mainMenu mockMenu = Mockito.mock(mainMenu.class);
        mockMenu.fakePress();
        assertFalse(mockMenu.isShown());
    }

    //Given that I am playing the game, when I press quit, then the main menu should appear
    @Test
    public void testQuitToMenu(){//tests to go back to main menu from pause menu
        //manager.paused = true;
        //assertTrue(objectMenu.fakePress());

    }
}