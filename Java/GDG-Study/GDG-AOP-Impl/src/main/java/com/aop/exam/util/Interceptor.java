package com.aop.exam.util;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

public class Interceptor implements MethodInterceptor {

    List<String> refList;

    /* NOTE : <BeanID, Path> */
    Map<String, String> beans;

    /* NOTE : <BeanID, Aspect<pointcut-ref, Method>> */
    Map<String, Aspect> aspect;

    /* NOTE : <pointcutID, expression> */
    Map<String, String> pointcut;

    Interceptor(List<String> refList, Map<String, String> beans, Map<String, Aspect> aspect, Map<String, String> pointcut) {
        this.beans = beans;
        this.refList = refList;
        this.aspect = aspect;
        this.pointcut = pointcut;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        /*
            TODO : execution 검사
            NOTE : execution에 해당하는 method면 before, after 구분 (around는 일단 제외)
         */
        int a = object.getClass().toString().indexOf('$');
        String className = object.getClass().toString().substring(6, a);
        String methodName = method.getName();
        String fullName = className + "." + methodName + "()";

        List<String> pointcutID = new ArrayList<>(); // NOTE : execution에 해당하는 pointcut 모음

        Collection<String> values = pointcut.values();

        for (String value : values) {
            if (value.contains(fullName)) {
                pointcutID.add(getKey(pointcut, value));
            }
        }

        List<Map<String, Method>> beforeList = new ArrayList<>();
        List<Map<String, Method>> afterList = new ArrayList<>();

        for (String s : refList) {
            Aspect temp = aspect.get(s);
            beforeList.addAll(temp.getBefore());
            afterList.addAll(temp.getAfter());
        }


        /* TODO : if Before가 있으면 ... 있는거 몽땅 실행 */
        for (String s : refList) {
            for (String d : pointcutID) {
                for (Map<String, Method> stringMethodMap : beforeList) {
                    Class<?> clazz = Class.forName(beans.get(s));
                    Constructor<?> ctor = clazz.getConstructor();
                    Object obj = ctor.newInstance();
                    stringMethodMap.get(d).invoke(obj);
                }
            }
        }

        Object returnValue = methodProxy.invokeSuper(object, args);

        /* TODO : if After가 있으면 ... 있는거 몽땅 실행 */
        for (String s : refList) {
            for (String d : pointcutID) {
                for (Map<String, Method> stringMethodMap : afterList) {
                    Class<?> clazz = Class.forName(beans.get(s));
                    Constructor<?> ctor = clazz.getConstructor();
                    Object obj = ctor.newInstance();
                    stringMethodMap.get(d).invoke(obj);
                }
            }
        }

        return returnValue;
    }

    private static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if(value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
