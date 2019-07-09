//package com.arishenk;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        int numberFirst = EnterNumber();
        int numberSecond = EnterNumber();
        String operation = EnterOperation();
        ChoiceOperation(operation, numberFirst, numberSecond);
    }

    public static int EnterNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number:");
        int number = in.nextInt();
        return number;
    }

    public static String EnterOperation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter operation:");
        String operation = in.next();
        return operation;
    }

    public static void ChoiceOperation(String operation, int numberFirst, int numberSecond) {
        switch(operation) {
            case "+":
                System.out.println("Result " + (numberFirst + numberSecond));
                break;
            case "-":
                System.out.println("Result " + (numberFirst - numberSecond));
                break;
            case "*":
                System.out.println("Result " + (numberFirst * numberSecond));
                break;
            case "/":
                if (numberSecond == 0) {
                    System.out.println("Division by zero!");
                    break;
                } else {
                    int modulo = numberFirst % numberSecond;
                    if ( modulo != 0) {
                        System.out.println("Result " + (numberFirst / numberSecond) + "(" + modulo + ")");
                        break;
                    }
                    else {
                        System.out.println("Result " + (numberFirst / numberSecond));
                        break;
                    }
                }
            default:
                System.out.print("Incorrect operation!");
                break;
        }
    }
}
