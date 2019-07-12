package com.arishenk;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws IOException {
        File dir = new File("/proc/");
        String[] list = dir.list();
        for (String fileName: list) {
            try {
                Integer PID = Integer.parseInt(fileName);
                File pidDir = new File("/proc/" + fileName + "/stat");
                FileReader fr = new FileReader("/proc/" + fileName + "/stat");
                Scanner inFile = new Scanner(fr);
                String pidInfo = inFile.nextLine();
                String[] massPidInfo = pidInfo.split(" ");
                System.out.println(fileName + " " + massPidInfo[1]);
            }
            catch (NumberFormatException err) {

            }
        }
    }
}
