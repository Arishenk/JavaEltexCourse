package main.java.com;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestCollection {

    public static void main(String[] args) {
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
}
