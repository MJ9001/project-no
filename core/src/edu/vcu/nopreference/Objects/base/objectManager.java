package edu.vcu.nopreference.Objects.base;

import java.util.List;

/**
 * Created by Mark on 10/10/2018.
 */

public class objectManager {

    List<objectBase> objects;

    objectManager()
    {

    }

    void addObject(objectBase object)
    {
        objects.add(object);
    }


}
