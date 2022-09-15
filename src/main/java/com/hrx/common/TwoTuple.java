package com.hrx.common;

import java.io.Serializable;


/**
 * @author hrx
 */
public class TwoTuple<T1, T2> implements Serializable {

    public final T1 x;

    public final T2 y;

    public TwoTuple(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

}