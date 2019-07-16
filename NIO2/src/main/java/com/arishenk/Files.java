package com.arishenk;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Files {

    public static void main(String[] args) throws IOException {
        File dir = new File("/home/arishenk/eltex/forDeleted");
        String[] list = dir.list();

        assert list != null;
        for (String fileName: list) {
            System.out.println(fileName);
        }

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        Path target = Paths.get("/home/arishenk/eltex/forDeleted/" + fileName);
        java.nio.file.Files.delete(target);
    }
}
