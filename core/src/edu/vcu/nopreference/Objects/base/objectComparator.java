package edu.vcu.nopreference.Objects.base;

import java.util.Comparator;

public class objectComparator implements Comparator<objectBase> {
    @Override
    public int compare(objectBase objectBase, objectBase t1) {
        //return t1.getDrawOrder()-objectBase.getDrawOrder();
        return 1;
    }
}
