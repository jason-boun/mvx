package com.jason.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by JiaBo on 2017/11/9.
 */

public class Util {

    public static <T> T getT(Object obj, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (obj.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
