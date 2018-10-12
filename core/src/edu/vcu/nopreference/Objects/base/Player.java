package edu.vcu.nopreference.Objects.base;
import com.badlogic.gdx.graphics.g2d.Sprite;

import edu.vcu.nopreference.Objects.renders.playerRender;
/**
 * Created by Mark on 10/10/2018.
 */

public class Player extends objectBase {

    public Player()
    {
        render = new playerRender(this);
        //sprite.setPosition(0,0);
        sprite.setBounds(100, 0, 200, 200);
    }
}
