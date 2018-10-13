package edu.vcu.nopreference.Objects.base;

import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/10/2018.
 */

public class Player extends objectBase {

    public Player()
    {
        render = new Render(this, "badlogic.jpg");
        //sprite.setPosition(0,0);
        setBounds(100, 0, 200, 200);
    }

    @Override
    public void onClick(int x, int y)
    {
        physics.Jump();
    }
}
