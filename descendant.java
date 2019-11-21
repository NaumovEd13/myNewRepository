package com.company.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class descendant extends secondAncester {
    public static List<Class> list=new ArrayList<>();
    public static void reflexClass(Class c){
        if(c.getSuperclass()==null){
            System.out.println("У этого класса нет родителей");
            return;
        }
        System.out.println(c.getSuperclass().getSimpleName());
        reflexClass(c.getSuperclass());
    }

    public static List<Class> reflexInterface(Class c){
        Class[]classes=c.getInterfaces();
        list.addAll(Arrays.asList(classes));
        if(c.getSuperclass()==null){
            return list;
        }
        reflexInterface(c.getSuperclass());
        return list;
    }

    public static void reflectMethods(Class c){
        Method[]arr=c.getMethods();
        System.out.println("У класса "+c.getSimpleName());
        for(Method m:arr){
            System.out.println(m.getName());
        }
        System.out.println("===========================================================");
        if(c.getSuperclass()==null){
            return;
        }
        reflectMethods(c.getSuperclass());
    }

    public static void changeSomeValue(Class c, String field) throws NoSuchFieldException, IllegalAccessException {
        Field fieldd=c.getDeclaredField(field);
        fieldd.setAccessible(true);
        fieldd.set(new secondAncester(), 10);
        int a=(int)fieldd.get(new secondAncester());
        System.out.println(a);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        reflexClass(descendant.class);
        for(Class c:reflexInterface(descendant.class)){
            System.out.println(c.getSimpleName());
        }
        reflectMethods(descendant.class);
        changeSomeValue(secondAncester.class, "a");
    }
}
