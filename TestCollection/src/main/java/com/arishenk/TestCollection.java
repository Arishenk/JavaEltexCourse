package com.arishenk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class TestCollection {

    public static final Integer NumberOfUser = 1000000;

    public static void main(String[] args) {
        arrayListInfo();
        setAndMapTest();
        listsTest();
    }

    public static void arrayListInfo() {
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        newlist.add(3);
        Class arraysInfo = newlist.getClass();
        System.out.println("Class name: " + arraysInfo.getName());

        Field[] fields = arraysInfo.getFields();
        System.out.println("Fields: ");
        for (Field testField : fields) {
            System.out.print(testField.getName());
        }

        Method[] methods = arraysInfo.getMethods();
        System.out.println("Methods: ");
        for (Method testMethod : methods) {
            System.out.println(testMethod.getName());
        }
    }

    public static void setAndMapTest() {
        HashSet<Integer> hashSet = new HashSet();
        HashMap<Integer, Integer> hashMap = new HashMap();

        long startTime = System.nanoTime();

        for (Integer i = 0; i < NumberOfUser; i++) {
            hashSet.add(i);
        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for add in hashSet: " + estimatedTime + " ns");

        Integer removingObject = hashSet.toArray(new Integer[0])[NumberOfUser - 1];

        startTime = System.nanoTime();

        hashSet.remove(removingObject);

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for remove from hashSet: " + estimatedTime + " ns");

        startTime = System.nanoTime();

        for (Integer i = 0; i < NumberOfUser; i++) {
            hashMap.put(i, i);
        }

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for add in hashMap: " + estimatedTime + " ns");

        startTime = System.nanoTime();

        hashMap.remove(NumberOfUser - 1);

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for remove from hashMap: " + estimatedTime + " ns");
    }

    public static void listsTest() {
        ArrayList<Integer> arrayList = new ArrayList();
        LinkedList<Integer> linkedList = new LinkedList();
        TreeSet<Integer> treeSet = new TreeSet();

        long startTime = System.nanoTime();

        for (Integer i = 0; i < NumberOfUser; i++) {
            arrayList.add(i);
        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for add in arrayList: " + estimatedTime + " ns");

        startTime = System.nanoTime();

        arrayList.remove(NumberOfUser - 1);

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for remove from arrayList: " + estimatedTime + " ns");

        startTime = System.nanoTime();

        for (Integer i = 0; i < NumberOfUser; i++) {
            linkedList.add(i);
        }

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for add in linkedList: " + estimatedTime + " ns");

        startTime = System.nanoTime();

        linkedList.remove(NumberOfUser - 1);

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for remove from linkedList: " + estimatedTime + " ns");

        startTime = System.nanoTime();

        for (Integer i = 0; i < NumberOfUser; i++) {
            treeSet.add(i);
        }

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for add in treeSet: " + estimatedTime + " ns");

        startTime = System.nanoTime();

        treeSet.remove(NumberOfUser - 1);

        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time for remove from treeSet: " + estimatedTime + " ns");

    }
}

