package com.arishenk;

import java.util.Scanner;

import static com.arishenk.WeekDays.*;

public class Enums {
    public static void main(String[] args) {
        System.out.println("Enter the day of week: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        switch (valueOf(str.toUpperCase())) {
            case MONDAY:
                System.out.println("5 days left until the weekend.");
                break;
            case TUESDAY:
                System.out.println("4 days left until the weekend.");
                break;
            case WEDNESDAY:
                System.out.println("3 days left until the weekend.");
                break;
            case THURSDAY:
                System.out.println("2 days left until the weekend.");
                break;
            case FRIDAY:
                System.out.println("1 days left until the weekend.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Hooray! weekends");
                break;
                default:
                    System.out.println("Uncorrected word!");
        }
    }
}