package com.aop.exam.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aspect {
    List<Map<String, Method>> Before = new ArrayList<>();
    List<Map<String, Method>> After = new ArrayList<>();

    public void addBefore(Class<?> clazz, String methodName, String pointcutRef) throws NoSuchMethodException {
        Map<String, Method> temp = new HashMap<>();
        temp.put(pointcutRef, clazz.getMethod(methodName));
        Before.add(temp);
    }

    public void addAfter(Class<?> clazz, String methodName, String pointcutRef) throws NoSuchMethodException {
        Map<String, Method> temp = new HashMap<>();
        temp.put(pointcutRef, clazz.getMethod(methodName));
        After.add(temp);
    }

    public List<Map<String, Method>> getBefore() {
        return Before;
    }

    public List<Map<String, Method>> getAfter() {
        return After;
    }
}
