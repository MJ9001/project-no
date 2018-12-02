package edu.vcu.nopreference.Objects.base.levelSelect;

import edu.vcu.nopreference.Objects.base.objectBase;
import edu.vcu.nopreference.Objects.physics.physicsGUI;
import edu.vcu.nopreference.Objects.renders.Render;

public class levelSelectInner extends objectBase {
    public levelSelectInner(String name, float posX, float posY, levelSelect level){

        if (level.getUnlocked()){
            render = new Render(this, name);
        }
        else{
            render = new Render(this, "lock.png");
        }
        //setBounds(posX, posY, 120, 108);
        sprite.setPosition(posX, posY);
    }

    @Override
    protected void initializePhysics() {
        GUIAsset=true;
        physics = new physicsGUI(this);
    }
}
