package com.arishenk;

import java.math.BigInteger;

public class BigTypes {
    public static void main(String[] args) throws InterruptedException {
        BigInteger firstNumber = new BigInteger(String.valueOf(Long.MAX_VALUE));
        firstNumber = firstNumber.pow(1000);
        System.out.println(firstNumber);
        Thread.sleep(10000);
    }
}
