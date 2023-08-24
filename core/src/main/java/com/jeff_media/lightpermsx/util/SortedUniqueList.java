package com.jeff_media.lightpermsx.util;

import java.util.ArrayList;
import java.util.Collections;

public class SortedUniqueList<T extends Comparable<T>> extends ArrayList<T> {

    @Override
    public boolean add(T t) {
        if (super.contains(t)) {
            return false;
        }
        super.add(t);
        Collections.sort(this);
        return true;

    }
}
