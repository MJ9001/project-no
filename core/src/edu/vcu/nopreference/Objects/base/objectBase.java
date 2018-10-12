package edu.vcu.nopreference.Objects.base;

import edu.vcu.nopreference.Objects.collisions.Collision;
import edu.vcu.nopreference.Objects.renders.Render;

/**
 * Created by Mark on 10/8/2018.
 */

public class objectBase {
    private int posX = 0;
    private int posY = 0;
    private int width = 0;
    private int height = 0;

    Render render;
    Collision collision;

    public void Draw() {
        render.draw();
    }

}
