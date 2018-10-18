package edu.vcu.nopreference.Objects.base;

import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;

public class levelSelectInner extends objectBase {
    public levelSelectInner(String name, float posX, float posY){
        render = new Render(this, name);
        sprite.setPosition(posX, posY);
    }

    @Override
    protected void initializePhysics() {
        physics = new physicsGUI(this);
    }
}
