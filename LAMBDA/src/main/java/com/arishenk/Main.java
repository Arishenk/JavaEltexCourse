package com.arishenk;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++)
            list.add(i);

        System.out.println(list.stream().map((x) -> x * x).reduce(0, Integer::sum));
    }
}
